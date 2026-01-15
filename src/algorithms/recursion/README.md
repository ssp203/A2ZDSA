# Recursion

This directory contains recursive problem solutions and techniques.

## Core Concepts

### What is Recursion?
A function that calls itself to solve smaller instances of the same problem.

### Components of Recursion
1. **Base Case**: Condition to stop recursion
2. **Recursive Case**: Function calls itself with modified parameters
3. **Progress towards base case**: Each call should move closer to base case

## Problems to Solve

### Basic Recursion
- Factorial calculation
- Fibonacci sequence
- Sum of natural numbers
- Power calculation (x^n)
- Print numbers 1 to N
- Print numbers N to 1

### Array/String Recursion
- Check if array is sorted
- Reverse an array
- Reverse a string
- Check palindrome
- Find maximum in array
- Sum of array elements

### Advanced Recursion
- Tower of Hanoi
- Generate all subsets (power set)
- Generate all permutations
- Generate all combinations
- String subsequences
- Letter combinations of phone number

### Recursion with Backtracking
- N-Queens problem
- Sudoku solver
- Rat in a maze
- Word search in grid

## Learning Path

1. **Master Base Cases**: Always identify stopping condition first
2. **Trust the Recursion**: Assume recursive call works for smaller input
3. **Visualize with Tree**: Draw recursion tree for complex problems
4. **Identify Pattern**: Many recursive problems follow similar patterns
5. **Optimize**: Learn to use memoization when needed

## Implementation Template

```java
/**
 * Problem: [Problem Name]
 * 
 * Approach: Recursive solution
 * - Base case: [condition]
 * - Recursive case: [how problem is broken down]
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?) - includes recursion stack
 */
public static ReturnType recursiveFunction(parameters) {
    // Base case
    if (baseCondition) {
        return baseValue;
    }
    
    // Recursive case
    // Do some work
    ReturnType result = recursiveFunction(modifiedParameters);
    // Process result if needed
    
    return result;
}
```

## Common Pitfalls

- Missing or incorrect base case → Stack overflow
- Not making progress towards base case → Infinite recursion
- Redundant calculations → Use memoization (DP)
- Deep recursion → Consider iterative approach or tail recursion

## Recursion vs Iteration

| Aspect | Recursion | Iteration |
|--------|-----------|-----------|
| Space | O(n) stack space | O(1) typically |
| Readability | Often clearer for tree/graph problems | Better for simple loops |
| Performance | Function call overhead | Generally faster |
| Use Case | Tree traversals, divide & conquer | Simple sequential operations |

## Interview Tips

- Always clarify space constraints (recursion uses stack space)
- For tree/graph problems, recursion is often more natural
- Can you convert to iteration if interviewer asks?
- Understanding recursion is crucial for Dynamic Programming
