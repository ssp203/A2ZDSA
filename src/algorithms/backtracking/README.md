# Backtracking

This directory contains backtracking algorithm implementations.

## What is Backtracking?

Backtracking is an algorithmic technique for solving problems by trying to build a solution incrementally, abandoning solutions ("backtracking") as soon as it determines that the solution cannot be completed.

**Key Idea**: Try all possibilities and backtrack when a solution path fails.

## Backtracking Template

```java
void backtrack(parameters, currentState, result) {
    // Base case: found valid solution
    if (isValidSolution(currentState)) {
        result.add(new ArrayList<>(currentState));
        return;
    }
    
    // Try all possible choices
    for (choice : possibleChoices) {
        // Make choice
        currentState.add(choice);
        
        // Recurse with updated state
        if (isValid(currentState)) {
            backtrack(parameters, currentState, result);
        }
        
        // Undo choice (backtrack)
        currentState.remove(currentState.size() - 1);
    }
}
```

## Classic Problems

### Permutations and Combinations
- Generate all permutations of an array
- Generate all combinations of size k
- Letter combinations of phone number
- Generate parentheses

### Subset Problems
- All subsets (power set)
- Subsets with sum equal to target
- Partition into k equal sum subsets

### Board/Grid Problems
- **N-Queens Problem**: Place N queens on N×N board
- **Sudoku Solver**: Fill 9×9 grid with valid numbers
- **Rat in a Maze**: Find path from start to end
- **Word Search**: Find word in 2D grid
- **Knight's Tour**: Visit all squares on chessboard

### String Problems
- Palindrome partitioning
- Word break II
- Letter case permutation
- Restore IP addresses

### Graph Problems
- All paths from source to target
- Hamiltonian path
- Graph coloring
- Subset sum variations

## Problem-Solving Strategy

1. **Identify Choices**: What decisions can be made at each step?
2. **Define Constraints**: What makes a choice valid?
3. **Define Goal**: When is a complete solution found?
4. **Implement**:
   - Make a choice
   - Recurse with updated state
   - Undo the choice (backtrack)

## Time Complexity

Most backtracking problems have exponential time complexity:
- Permutations: O(n! × n)
- Subsets: O(2ⁿ × n)
- Combinations: O(C(n,k) × k)

The actual complexity depends on:
- Number of choices at each level
- Depth of recursion tree
- Pruning effectiveness

## Optimization Techniques

### 1. Pruning
Skip branches that cannot lead to valid solutions:
```java
if (!isValid(currentState)) {
    return; // Prune this branch
}
```

### 2. Early Termination
Stop as soon as one solution is found (if only one needed):
```java
if (found) return true;
```

### 3. Sorting for Pruning
Sort input to skip duplicates efficiently:
```java
Arrays.sort(candidates);
if (i > 0 && candidates[i] == candidates[i-1]) continue;
```

### 4. Visited Array
Track visited elements to avoid cycles:
```java
boolean[] visited = new boolean[n];
```

## Backtracking vs Recursion vs DFS

- **Recursion**: General technique of function calling itself
- **Backtracking**: Recursion + try all options + undo choices
- **DFS**: Backtracking applied to tree/graph traversal

## Interview Tips

1. **Recognize the pattern**: "Find all", "generate all", "count all ways"
2. **Draw the decision tree**: Visualize choices at each level
3. **Start simple**: Write base case first, then recursive case
4. **Test with small input**: Verify logic with minimal example
5. **Discuss complexity**: Interviewers expect you to know it's exponential
6. **Mention optimizations**: Show awareness of pruning techniques

## Common Mistakes

- Forgetting to backtrack (undo choice)
- Not handling duplicates in input
- Modifying global state without restoring
- Not considering base case properly
- Inefficient copying of current state
