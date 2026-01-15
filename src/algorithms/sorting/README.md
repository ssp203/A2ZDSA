# Sorting Algorithms

This directory contains implementations of various sorting algorithms.

## Algorithms to Implement

### Basic Sorting (O(n²))
- **Bubble Sort** - Repeatedly swap adjacent elements if they are in wrong order
- **Selection Sort** - Find minimum element and place it at the beginning
- **Insertion Sort** - Build sorted array one item at a time

### Efficient Sorting (O(n log n))
- **Merge Sort** - Divide and conquer algorithm that divides array into halves
- **Quick Sort** - Divide and conquer using pivot element
- **Heap Sort** - Uses heap data structure to sort elements

### Other Sorting Algorithms
- **Counting Sort** - Integer sorting algorithm (O(n+k) time)
- **Radix Sort** - Sorts numbers digit by digit
- **Bucket Sort** - Distributes elements into buckets

## Learning Objectives

1. Understand time and space complexity trade-offs
2. Learn when to use which sorting algorithm
3. Implement both iterative and recursive approaches
4. Compare stability and in-place properties

## Implementation Template

```java
/**
 * Algorithm Name
 * 
 * Approach:
 * - [Brief description]
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 * Stable: Yes/No
 * In-place: Yes/No
 */
public static void sortingAlgorithm(int[] arr) {
    // Implementation
}
```

## Key Concepts

- **Stable Sort**: Maintains relative order of equal elements
- **In-place Sort**: Uses O(1) extra space
- **Comparison-based**: Uses comparisons to determine order
- **Adaptive**: Takes advantage of existing order in data
