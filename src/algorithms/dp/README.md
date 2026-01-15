# Dynamic Programming (DP)

This directory contains dynamic programming solutions.

## What is Dynamic Programming?

Dynamic Programming is an optimization technique that solves complex problems by breaking them down into simpler subproblems and storing their solutions to avoid redundant calculations.

**Key Properties**:
1. **Overlapping Subproblems**: Same subproblems are solved multiple times
2. **Optimal Substructure**: Optimal solution can be constructed from optimal solutions of subproblems

## DP Approaches

### 1. Memoization (Top-Down)
- Start with original problem
- Recursively break down into subproblems
- Store results in cache (usually HashMap or array)
- Check cache before computing

```java
int[] memo = new int[n + 1];
Arrays.fill(memo, -1);

int solve(int n) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    
    memo[n] = solve(n-1) + solve(n-2);
    return memo[n];
}
```

### 2. Tabulation (Bottom-Up)
- Start with base cases
- Iteratively build up to original problem
- Store results in table (usually array)
- More space efficient, avoids recursion overhead

```java
int solve(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    
    return dp[n];
}
```

## Classic DP Problems

### 1D DP Problems
- Fibonacci sequence
- Climbing stairs
- House robber
- Decode ways
- Coin change
- Longest increasing subsequence (LIS)
- Maximum subarray (Kadane's algorithm)

### 2D DP Problems
- Unique paths in grid
- Minimum path sum
- Edit distance
- Longest common subsequence (LCS)
- Longest common substring
- 0/1 Knapsack problem
- Unbounded knapsack
- Matrix chain multiplication

### String DP
- Palindrome problems
- Word break
- Regular expression matching
- Wildcard matching
- Interleaving strings

### Interval DP
- Burst balloons
- Minimum cost to merge stones
- Palindrome partitioning

### Tree DP
- Binary tree maximum path sum
- House robber III
- Diameter of binary tree

### Bitmask DP
- Traveling salesman problem
- Assignment problem
- Subset sum with all subsets

## Problem-Solving Framework

### Step 1: Identify if it's DP
Signs that suggest DP:
- "Find maximum/minimum"
- "Count number of ways"
- "Can you reach/achieve"
- Combinatorial optimization
- Decision making at each step

### Step 2: Define State
What information do you need to solve subproblems?
- `dp[i]` = answer for input of size i
- `dp[i][j]` = answer for subproblem involving indices i and j
- `dp[i][j][k]` = answer with three dimensions

### Step 3: Find Recurrence Relation
How to compute `dp[i]` from previous states?
- `dp[i] = function(dp[i-1], dp[i-2], ...)`

### Step 4: Identify Base Cases
What are the trivial cases?
- Often: `dp[0]`, `dp[1]`, or boundaries

### Step 5: Decide Order of Computation
For tabulation: ensure subproblems are solved before they're needed

### Step 6: Optimize Space (if possible)
Can you reduce space complexity?
- If `dp[i]` only depends on `dp[i-1]`, use O(1) space
- For 2D DP, sometimes can reduce to 1D

## Example: Fibonacci

### Recursion (Inefficient)
```java
// Time: O(2^n), Space: O(n)
int fib(int n) {
    if (n <= 1) return n;
    return fib(n-1) + fib(n-2);
}
```

### Memoization (Top-Down DP)
```java
// Time: O(n), Space: O(n)
int fib(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    memo[n] = fib(n-1, memo) + fib(n-2, memo);
    return memo[n];
}
```

### Tabulation (Bottom-Up DP)
```java
// Time: O(n), Space: O(n)
int fib(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
```

### Space Optimized
```java
// Time: O(n), Space: O(1)
int fib(int n) {
    if (n <= 1) return n;
    int prev2 = 0, prev1 = 1;
    for (int i = 2; i <= n; i++) {
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}
```

## Common Patterns

### Pattern 1: Min/Max Path to Target
- State: `dp[i]` = min/max cost to reach position i
- Transition: Consider all ways to reach i

### Pattern 2: Count Ways
- State: `dp[i]` = number of ways to achieve state i
- Transition: Sum of ways from previous states

### Pattern 3: Decision Making
- State: `dp[i][0/1]` = answer if we take/don't take element i
- Transition: Max/min of both choices

### Pattern 4: Subsequence/Substring
- State: `dp[i][j]` = answer for s1[0..i] and s2[0..j]
- Transition: Based on character match/mismatch

## Interview Tips

1. **Start with recursion**: Write brute force recursive solution first
2. **Identify repeated work**: Notice which subproblems are computed multiple times
3. **Add memoization**: Cache recursive results
4. **Convert to tabulation**: Rewrite as iterative if needed
5. **Optimize space**: Reduce dimensions where possible
6. **Explain your thought process**: Walk through small examples
7. **Time/Space complexity**: Always analyze and state them

## Common Mistakes

- Not identifying all required dimensions for state
- Wrong order of computation in tabulation
- Forgetting base cases
- Off-by-one errors in array indices
- Not considering edge cases (empty input, n=0, n=1)
- Overcomplicating the state representation

## Practice Strategy

1. Start with classic problems (Fibonacci, climbing stairs)
2. Master 1D DP before moving to 2D
3. Practice both memoization and tabulation
4. Learn to identify DP patterns in new problems
5. Time yourself to build speed
6. Review multiple solutions for the same problem
