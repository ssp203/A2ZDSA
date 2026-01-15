# Searching Algorithms

This directory contains implementations of various searching algorithms.

## Algorithms to Implement

### Linear Search
- **Basic Linear Search** - Sequential search through array
- **Sentinel Linear Search** - Optimized version with sentinel value
- Time Complexity: O(n)
- Space Complexity: O(1)

### Binary Search
- **Iterative Binary Search** - Search in sorted array by dividing search space
- **Recursive Binary Search** - Recursive implementation of binary search
- **Binary Search Variants**:
  - First occurrence of element
  - Last occurrence of element
  - Count occurrences
  - Search in rotated sorted array
- Time Complexity: O(log n)
- Space Complexity: O(1) iterative, O(log n) recursive

### Ternary Search
- **Ternary Search** - Divides array into three parts
- Time Complexity: O(log₃ n)
- Useful for: Finding maximum/minimum in unimodal functions

### Advanced Search Techniques
- **Exponential Search** - Search in unbounded/infinite arrays
- **Interpolation Search** - Better than binary search for uniformly distributed data
- **Jump Search** - Block-based search algorithm

## Learning Objectives

1. Understand when to use each searching technique
2. Master binary search and its variations (most important for interviews)
3. Learn to identify search space reduction problems
4. Practice edge case handling (empty arrays, duplicates, etc.)

## Common Patterns

### Binary Search Template
```java
public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1; // Not found
}
```

## Interview Tips

- Binary search is one of the most common interview patterns
- Always check for sorted array requirement
- Be careful with integer overflow: use `left + (right - left) / 2` instead of `(left + right) / 2`
- Practice identifying binary search problems (not always obvious!)
- Common applications: finding boundaries, search space reduction, optimization problems
