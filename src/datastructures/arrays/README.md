# Arrays

This directory contains array-based data structure implementations and problem solutions.

## Core Concepts

An array is a collection of elements stored in contiguous memory locations. Each element can be accessed using its index.

**Properties**:
- Fixed size (in Java, use ArrayList for dynamic size)
- O(1) random access by index
- Elements stored contiguously in memory
- Cache-friendly due to spatial locality

## Topics to Cover

### 1. Basic Operations
```java
// Declaration and initialization
int[] arr = new int[5];
int[] arr2 = {1, 2, 3, 4, 5};

// Access: O(1)
int element = arr[2];

// Modification: O(1)
arr[2] = 10;

// Traversal: O(n)
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### 2. Searching
- Linear Search: O(n)
- Binary Search (sorted array): O(log n)

### 3. Insertion
- At end: O(1) if space available
- At beginning or middle: O(n) due to shifting

### 4. Deletion
- From end: O(1)
- From beginning or middle: O(n) due to shifting

### 5. Common Operations
- Find maximum/minimum
- Reverse array
- Rotate array
- Find duplicates
- Remove duplicates (sorted/unsorted)
- Merge two sorted arrays
- Find intersection/union

## Array Problem Patterns

### Pattern 1: Two Pointers
Use two pointers moving towards each other or in the same direction.

**Problems**:
- Two Sum (sorted array)
- Three Sum
- Container with most water
- Remove duplicates from sorted array
- Move zeros
- Sort colors (Dutch National Flag)

```java
// Two pointers from both ends
int left = 0, right = arr.length - 1;
while (left < right) {
    // Process based on condition
    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

### Pattern 2: Sliding Window
Maintain a window of elements and slide it across the array.

**Problems**:
- Maximum sum subarray of size k
- Longest substring without repeating characters
- Minimum window substring
- Find all anagrams in a string

```java
// Fixed-size sliding window
int windowSum = 0;
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
int maxSum = windowSum;

for (int i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

### Pattern 3: Prefix Sum
Precompute cumulative sums for range queries.

**Problems**:
- Range sum query
- Subarray sum equals k
- Contiguous array
- Product of array except self

```java
// Build prefix sum array
int[] prefixSum = new int[n + 1];
for (int i = 0; i < n; i++) {
    prefixSum[i + 1] = prefixSum[i] + arr[i];
}

// Range sum from i to j: O(1)
int sum = prefixSum[j + 1] - prefixSum[i];
```

### Pattern 4: Kadane's Algorithm
Find maximum sum subarray.

```java
int maxSoFar = arr[0];
int maxEndingHere = arr[0];

for (int i = 1; i < arr.length; i++) {
    maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
}
```

### Pattern 5: Array Modification In-Place
Modify array without using extra space.

**Problems**:
- Rotate array
- Next permutation
- First missing positive
- Set matrix zeros

### Pattern 6: Intervals
Work with array of intervals.

**Problems**:
- Merge intervals
- Insert interval
- Non-overlapping intervals
- Meeting rooms

```java
// Sort intervals
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

// Merge overlapping intervals
List<int[]> result = new ArrayList<>();
int[] current = intervals[0];

for (int i = 1; i < intervals.length; i++) {
    if (intervals[i][0] <= current[1]) {
        // Overlapping - merge
        current[1] = Math.max(current[1], intervals[i][1]);
    } else {
        // Not overlapping - add current and move to next
        result.add(current);
        current = intervals[i];
    }
}
result.add(current);
```

## Time Complexities

| Operation | Time Complexity |
|-----------|----------------|
| Access | O(1) |
| Search (unsorted) | O(n) |
| Search (sorted) | O(log n) with binary search |
| Insert at end | O(1) if space available |
| Insert at beginning/middle | O(n) |
| Delete from end | O(1) |
| Delete from beginning/middle | O(n) |

## Space Optimization Techniques

### 1. Two Pointers for In-Place
- Avoid creating new arrays
- Use two pointers to rearrange elements

### 2. Cyclic Sort
- For problems involving numbers in range [1, n]
- O(n) time, O(1) space

### 3. Bit Manipulation
- Use bits to store multiple states
- Useful when range is small

## Interview Tips

1. **Clarify constraints**: Array size? Sorted? Duplicates allowed?
2. **Think about edge cases**: Empty array, single element, all same values
3. **Consider sorting**: Sometimes sorting simplifies the problem
4. **Two pointers first**: Many array problems can be solved with two pointers
5. **Draw it out**: Visualize with small example
6. **Time-space tradeoff**: Often can trade space for time (hash map)
7. **In-place operations**: Try to minimize extra space

## Common Problems to Practice

### Easy
- Two Sum
- Best Time to Buy and Sell Stock
- Contains Duplicate
- Maximum Subarray
- Merge Sorted Array
- Plus One
- Remove Duplicates from Sorted Array

### Medium
- Three Sum
- Container with Most Water
- Product of Array Except Self
- Find Peak Element
- Search in Rotated Sorted Array
- Next Permutation
- Subarray Sum Equals K
- Longest Consecutive Sequence

### Hard
- Trapping Rain Water
- First Missing Positive
- Median of Two Sorted Arrays
- Sliding Window Maximum
- Minimum Window Substring

## Advanced Topics

- **Segment Tree**: Range query and update in O(log n)
- **Fenwick Tree (Binary Indexed Tree)**: Efficient prefix sum queries
- **Sparse Table**: Static range queries in O(1) after O(n log n) preprocessing
- **Square Root Decomposition**: Balance between array and segment tree

## Java-Specific Notes

```java
// Array
int[] arr = new int[10]; // Fixed size

// ArrayList (dynamic)
List<Integer> list = new ArrayList<>();
list.add(1);  // O(1) amortized
list.get(0);  // O(1)
list.remove(list.size() - 1);  // O(1)
list.remove(0);  // O(n)

// Arrays utility class
Arrays.sort(arr);
Arrays.binarySearch(arr, target);
Arrays.fill(arr, value);
Arrays.copyOf(arr, newLength);
```

## Practice Strategy

1. Start with basic two-pointer problems
2. Master sliding window technique
3. Learn to identify when to use prefix sum
4. Practice interval problems
5. Move to advanced techniques (Kadane's, cyclic sort)
6. Solve variety of problems to recognize patterns
