# Heap (Priority Queue)

This directory contains heap data structure implementations.

## What is a Heap?

A heap is a complete binary tree that satisfies the heap property:
- **Max Heap**: Parent ≥ Children (root is maximum)
- **Min Heap**: Parent ≤ Children (root is minimum)

**Key Properties**:
- Complete binary tree (filled left to right)
- Can be efficiently represented as an array
- Root is always at index 0
- For node at index i:
  - Left child: 2*i + 1
  - Right child: 2*i + 2
  - Parent: (i-1) / 2

## Why Use Heaps?

- **Efficient priority queue implementation**
- **O(1) access to min/max element**
- **O(log n) insertion and deletion**
- **In-place array representation**

## Array Representation

```
Array: [10, 8, 6, 4, 5, 3, 2]

Tree representation:
       10
      /  \
     8    6
    / \  / \
   4  5 3  2
```

## Min Heap Implementation

```java
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }
    
    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }
    
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    // Insert element - O(log n)
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        
        // Insert at end
        heap[size] = value;
        int current = size;
        size++;
        
        // Heapify up
        while (current != 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    
    // Get minimum - O(1)
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }
    
    // Extract minimum - O(log n)
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        
        if (size == 1) {
            size--;
            return heap[0];
        }
        
        // Store root and replace with last element
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        // Heapify down
        minHeapify(0);
        
        return root;
    }
    
    // Heapify down from index i
    private void minHeapify(int i) {
        int smallest = i;
        int leftChild = left(i);
        int rightChild = right(i);
        
        if (leftChild < size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }
        
        if (rightChild < size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }
        
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    
    // Decrease key - O(log n)
    public void decreaseKey(int i, int newValue) {
        heap[i] = newValue;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    
    // Delete element at index - O(log n)
    public void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
    
    // Build heap from array - O(n)
    public void buildHeap(int[] arr) {
        capacity = arr.length;
        size = arr.length;
        heap = arr.clone();
        
        // Start from last non-leaf node
        for (int i = (size / 2) - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }
}
```

## Max Heap Implementation

Similar to Min Heap, but reverse comparisons:
- Heapify up: while parent < current
- Heapify down: find largest among node and children

## Using Java's PriorityQueue

```java
// Min Heap (default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
// or
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// Custom comparator
PriorityQueue<Task> pq = new PriorityQueue<>(
    (a, b) -> a.priority - b.priority
);

// Operations
pq.offer(10);        // Insert - O(log n)
pq.poll();           // Extract min/max - O(log n)
pq.peek();           // Get min/max - O(1)
pq.isEmpty();        // Check if empty - O(1)
pq.size();           // Get size - O(1)
```

## Heap Operations Complexity

| Operation | Time Complexity |
|-----------|-----------------|
| Insert | O(log n) |
| Extract Min/Max | O(log n) |
| Get Min/Max | O(1) |
| Decrease Key | O(log n) |
| Delete | O(log n) |
| Build Heap | O(n) |
| Heapify | O(log n) |

## Common Heap Patterns

### Pattern 1: Top K Elements

**Find K largest/smallest elements**:
```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.peek();
}
```

**Problems**:
- Kth largest element
- Top K frequent elements
- K closest points to origin
- Kth smallest element in sorted matrix

### Pattern 2: Merge K Sorted

**Merge K sorted lists/arrays**:
```java
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(
        (a, b) -> a.val - b.val
    );
    
    // Add first node of each list
    for (ListNode list : lists) {
        if (list != null) {
            pq.offer(list);
        }
    }
    
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    while (!pq.isEmpty()) {
        ListNode node = pq.poll();
        current.next = node;
        current = current.next;
        
        if (node.next != null) {
            pq.offer(node.next);
        }
    }
    
    return dummy.next;
}
```

**Problems**:
- Merge K sorted lists
- Merge K sorted arrays
- Smallest range covering K lists

### Pattern 3: Two Heaps (Median)

**Find median from data stream**:
```java
class MedianFinder {
    PriorityQueue<Integer> maxHeap; // Left half
    PriorityQueue<Integer> minHeap; // Right half
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```

**Problems**:
- Find median from data stream
- Sliding window median
- IPO (maximize capital)

### Pattern 4: Scheduling

**Meeting rooms/task scheduling**:
```java
public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for (int[] interval : intervals) {
        if (!pq.isEmpty() && pq.peek() <= interval[0]) {
            pq.poll();
        }
        pq.offer(interval[1]);
    }
    
    return pq.size();
}
```

**Problems**:
- Meeting rooms II
- Task scheduler
- CPU tasks
- Minimum platforms required

## Classic Problems

### Easy
- Kth largest element in array
- Last stone weight
- Relative ranks
- K closest points to origin

### Medium
- Top K frequent elements
- Kth smallest element in sorted matrix
- Find K pairs with smallest sums
- Ugly number II
- Reorganize string
- Task scheduler
- Find median from data stream
- Meeting rooms II

### Hard
- Merge K sorted lists
- Sliding window median
- Maximum performance of a team
- IPO
- Employee free time

## Heap Sort

Using heap to sort array in O(n log n):

```java
public void heapSort(int[] arr) {
    int n = arr.length;
    
    // Build max heap - O(n)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }
    
    // Extract elements one by one - O(n log n)
    for (int i = n - 1; i > 0; i--) {
        // Move current root to end
        swap(arr, 0, i);
        
        // Heapify reduced heap
        heapify(arr, i, 0);
    }
}

private void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }
    
    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }
    
    if (largest != i) {
        swap(arr, i, largest);
        heapify(arr, n, largest);
    }
}
```

## Applications

1. **Priority Queues**: Process tasks by priority
2. **Dijkstra's Algorithm**: Shortest path
3. **Prim's Algorithm**: Minimum spanning tree
4. **Huffman Coding**: Data compression
5. **Median Maintenance**: Find median in stream
6. **Job Scheduling**: CPU scheduling, task management
7. **K-way Merge**: Merge multiple sorted streams

## Interview Tips

1. **Recognize "K" problems**: Top K, Kth largest/smallest
2. **Min heap for K largest**: Maintain K elements, pop smallest
3. **Max heap for K smallest**: Maintain K elements, pop largest
4. **Two heaps for median**: Balance elements on both sides
5. **Custom comparators**: Learn to write for complex objects
6. **Space complexity**: Heap uses O(k) space for top K problems
7. **Build heap**: O(n) is better than n insertions O(n log n)

## Common Mistakes

- Wrong comparator (ascending vs descending)
- Not maintaining heap size for top K problems
- Forgetting to check if heap is empty before poll/peek
- Using wrong heap type (min vs max)
- Not balancing heaps properly (two heap pattern)
- Inefficient heap construction (use buildHeap instead of repeated inserts)

## Practice Strategy

1. Implement min heap and max heap from scratch
2. Master top K element problems
3. Practice merge K sorted problems
4. Learn two-heap median pattern
5. Solve scheduling problems with heap
6. Understand heap sort
7. Practice with custom comparators
