# Hash Table (Hash Map)

This directory contains hash table implementations and problem solutions.

## What is a Hash Table?

A hash table is a data structure that implements an associative array, mapping keys to values using a hash function.

**Key Concepts**:
- **Hash Function**: Converts key to array index
- **Collision**: When two keys hash to same index
- **Load Factor**: ratio of entries to table size
- **Rehashing**: Resizing table when load factor exceeds threshold

## Hash Function

A good hash function should:
- Be deterministic (same key → same hash)
- Distribute keys uniformly
- Be fast to compute
- Minimize collisions

```java
// Simple hash function for integers
int hash(int key, int tableSize) {
    return Math.abs(key) % tableSize;
}

// Hash function for strings
int hash(String key, int tableSize) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash = (hash * 31 + c) % tableSize;
    }
    return Math.abs(hash);
}
```

## Collision Resolution

### 1. Chaining (Separate Chaining)
Each bucket stores a linked list of entries.

```java
class HashMapChaining<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public HashMapChaining(int capacity) {
        this.capacity = capacity;
        table = (Entry<K, V>[]) new Entry[capacity];
        size = 0;
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        
        // Update if key exists
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        
        // Insert at beginning of chain
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
    }
    
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        
        return null;
    }
    
    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;
        
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public int size() {
        return size;
    }
}
```

**Pros**: Simple, handles high load factors well  
**Cons**: Extra memory for pointers, cache unfriendly

### 2. Open Addressing
Store all entries in the table itself, probe for next empty slot.

**Linear Probing**: Check next slot sequentially  
**Quadratic Probing**: Check slots at quadratic intervals  
**Double Hashing**: Use second hash function for probe sequence

```java
// Linear Probing example
class HashMapLinearProbing {
    private class Entry {
        int key;
        int value;
        boolean deleted;
        
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Entry[] table;
    private int size;
    private int capacity;
    
    public HashMapLinearProbing(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
        size = 0;
    }
    
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        
        while (table[index] != null && !table[index].deleted) {
            if (table[index].key == key) {
                table[index].value = value;
                return;
            }
            index = (index + 1) % capacity;
        }
        
        table[index] = new Entry(key, value);
        size++;
    }
    
    public Integer get(int key) {
        int index = hash(key);
        
        while (table[index] != null) {
            if (!table[index].deleted && table[index].key == key) {
                return table[index].value;
            }
            index = (index + 1) % capacity;
        }
        
        return null;
    }
    
    public void remove(int key) {
        int index = hash(key);
        
        while (table[index] != null) {
            if (!table[index].deleted && table[index].key == key) {
                table[index].deleted = true;
                size--;
                return;
            }
            index = (index + 1) % capacity;
        }
    }
}
```

**Pros**: Better cache performance, no extra space for pointers  
**Cons**: Requires good load factor management, deletion complex

## Java's HashMap

```java
// HashMap (not synchronized)
Map<String, Integer> map = new HashMap<>();

// Basic operations - Average O(1)
map.put("key", 10);          // Insert/Update
map.get("key");              // Get value
map.remove("key");           // Remove
map.containsKey("key");      // Check if key exists
map.containsValue(10);       // Check if value exists
map.size();                  // Get size
map.isEmpty();               // Check if empty
map.clear();                 // Remove all

// Iteration
for (String key : map.keySet()) {
    System.out.println(key + ": " + map.get(key));
}

for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Default value
map.getOrDefault("key", 0);

// Compute if absent
map.putIfAbsent("key", 10);
map.computeIfAbsent("key", k -> computeValue(k));

// Merge
map.merge("key", 1, Integer::sum); // Add 1 to existing value
```

## HashSet

Set implementation using HashMap internally.

```java
Set<Integer> set = new HashSet<>();

set.add(10);           // O(1) average
set.remove(10);        // O(1) average
set.contains(10);      // O(1) average
set.size();            // O(1)
```

## Common Hash Table Patterns

### Pattern 1: Frequency Counter
Count occurrences of elements.

```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    
    // Count frequencies
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    // Use heap to find top K
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a, b) -> freq.get(a) - freq.get(b)
    );
    
    for (int num : freq.keySet()) {
        pq.offer(num);
        if (pq.size() > k) {
            pq.poll();
        }
    }
    
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        result[i] = pq.poll();
    }
    
    return result;
}
```

**Problems**: Two sum, group anagrams, top K frequent elements

### Pattern 2: Index Mapping
Map value to index/position.

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    
    return new int[]{-1, -1};
}
```

**Problems**: Two sum, subarray sum equals K, continuous subarray sum

### Pattern 3: Seen Set
Track elements already encountered.

```java
public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
    }
    return false;
}
```

**Problems**: Contains duplicate, longest substring without repeating characters

### Pattern 4: Grouping
Group elements by some criteria.

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    
    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(str);
    }
    
    return new ArrayList<>(map.values());
}
```

**Problems**: Group anagrams, group shifted strings

## Time Complexities

| Operation | Average | Worst |
|-----------|---------|-------|
| Insert | O(1) | O(n) |
| Delete | O(1) | O(n) |
| Search | O(1) | O(n) |
| Space | O(n) | O(n) |

## Classic Problems

### Easy
- Two sum
- Contains duplicate
- Valid anagram
- Intersection of two arrays
- Happy number
- First unique character in string
- Ransom note

### Medium
- Group anagrams
- Top K frequent elements
- Subarray sum equals K
- Longest substring without repeating characters
- 4Sum II
- Sort characters by frequency
- Find duplicate subtrees
- LRU Cache

### Hard
- Longest consecutive sequence
- Substring with concatenation of all words
- Minimum window substring
- First missing positive

## Applications

1. **Database Indexing**: Fast record lookup
2. **Caching**: LRU cache, memoization
3. **Symbol Tables**: Compilers, interpreters
4. **Duplicate Detection**: Find duplicates in data
5. **Frequency Counting**: Analytics, statistics
6. **Associative Arrays**: Key-value storage

## Interview Tips

1. **Recognize O(1) lookup**: When need fast search/insert
2. **Use for counting**: Frequency, occurrences
3. **Handle collisions**: Know about chaining and open addressing
4. **Space-time tradeoff**: HashMap trades space for time
5. **Key types**: Immutable keys (String, Integer, custom classes)
6. **Null handling**: Check if key exists before accessing
7. **Load factor**: Default 0.75 in Java HashMap

## HashMap vs TreeMap vs LinkedHashMap

| Feature | HashMap | TreeMap | LinkedHashMap |
|---------|---------|---------|---------------|
| Order | No order | Sorted by key | Insertion order |
| Get/Put | O(1) avg | O(log n) | O(1) avg |
| Null keys | 1 allowed | Not allowed | 1 allowed |
| Use case | Fast lookup | Sorted data | Maintain order |

## Common Mistakes

- Using mutable objects as keys
- Not overriding hashCode() and equals() for custom keys
- Assuming order is maintained (use LinkedHashMap)
- Not handling null values properly
- Inefficient hash functions causing many collisions
- Not considering load factor and rehashing

## Practice Strategy

1. Implement hash table from scratch (chaining and open addressing)
2. Master two sum and its variants
3. Practice frequency counting problems
4. Learn grouping patterns (anagrams, etc.)
5. Solve sliding window with hash map
6. Understand LRU cache implementation
7. Practice with complex key types
