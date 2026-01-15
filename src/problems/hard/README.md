# Hard Difficulty Problems

This directory contains solutions to hard difficulty DSA problems.

## Problem Selection Criteria

Hard problems typically involve:
- Advanced algorithms and complex data structures
- Multiple concepts combined in non-obvious ways
- Significant optimization required
- Deep algorithmic insights needed
- Edge cases that are not immediately apparent
- Often require multiple approaches to solve optimally

## Categories

### Advanced Dynamic Programming
- Edit distance
- Regular expression matching
- Longest valid parentheses
- Interleaving strings
- Distinct subsequences
- Word break II
- Palindrome partitioning II
- Dungeon game
- Best time to buy and sell stock III/IV

### Graph Algorithms
- Word ladder II
- Alien dictionary
- Critical connections (bridges)
- Shortest path visiting all nodes
- Minimum cost to make at least one valid path
- Swim in rising water
- Bus routes

### Advanced Trees
- Binary tree maximum path sum
- Serialize and deserialize binary tree
- Recover binary search tree
- Count of smaller numbers after self

### String Algorithms
- Minimum window substring
- Substring with concatenation of all words
- Palindrome pairs
- Text justification
- Longest substring with at most K distinct characters

### Array & Matrix
- Trapping rain water
- First missing positive
- Median of two sorted arrays
- Maximum rectangle
- Maximal rectangle in histogram
- Candy distribution

### Backtracking
- N-Queens II
- Sudoku solver
- Word search II
- Regular expression matching

### Advanced Data Structures
- LFU Cache
- All O(1) data structure
- Max stack
- Design search autocomplete system

### Computational Geometry
- Skyline problem
- Largest rectangle in histogram

### Sliding Window
- Sliding window maximum
- Sliding window median
- Minimum window substring

## Problem Format

```java
/**
 * Problem: [Problem Name]
 * Source: [LeetCode #123 / Competition / Company Interview]
 * Difficulty: Hard
 * 
 * Problem Statement:
 * [Detailed description]
 * 
 * Examples:
 * Example 1:
 * Input: [example]
 * Output: [example]
 * Explanation: [detailed explanation]
 * 
 * Example 2:
 * Input: [example]
 * Output: [example]
 * 
 * Constraints:
 * - [Critical constraints]
 * 
 * Key Insights:
 * - [Non-obvious observations needed to solve]
 * 
 * Approach 1: [Brute Force - if applicable]
 * - [Description]
 * - Why it doesn't work or is too slow
 * - Time: O(?), Space: O(?)
 * 
 * Approach 2: [Intermediate Solution]
 * - [Description]
 * - Time: O(?), Space: O(?)
 * 
 * Approach 3: [Optimal Solution]
 * - [Detailed explanation of insights]
 * - [Algorithm steps]
 * - Time: O(?), Space: O(?)
 * 
 * Edge Cases:
 * - [List non-obvious edge cases]
 */
```

## Learning Approach

### Prerequisites
Before attempting hard problems, ensure mastery of:
- All medium-level patterns
- Advanced data structures (segment tree, Fenwick tree, trie)
- Complex dynamic programming
- Graph algorithms (Dijkstra, topological sort, strongly connected components)
- Advanced techniques (binary search on answer, sliding window, two pointers)

### Study Strategy

1. **Understand the problem deeply**: Spend 10-15 minutes analyzing
2. **Identify the core challenge**: What makes this problem hard?
3. **Break it down**: Can it be split into subproblems?
4. **Research if stuck**: After genuine attempt (60+ minutes)
5. **Study optimal solution**: Understand the insights
6. **Implement from scratch**: Don't copy-paste
7. **Revisit**: After 1 week, 1 month, 3 months

## Common Hard Problem Patterns

### Pattern 1: Multiple DP Dimensions
Problems requiring 2D or 3D DP with complex state transitions.

**Examples**:
- Edit distance
- Longest palindromic subsequence
- Interleaving strings

### Pattern 2: Graph + DP
Combine graph traversal with dynamic programming.

**Examples**:
- Word ladder II
- Cheapest flights within K stops
- Path with maximum probability

### Pattern 3: Binary Search on Answer
Search for answer in a range using binary search.

**Examples**:
- Kth smallest element in sorted matrix
- Split array largest sum
- Capacity to ship packages within D days

### Pattern 4: Monotonic Stack/Deque
Maintain increasing/decreasing order for optimal lookups.

**Examples**:
- Largest rectangle in histogram
- Maximal rectangle
- Sliding window maximum

### Pattern 5: Advanced String Matching
Trie, KMP, or rolling hash for string problems.

**Examples**:
- Word search II
- Stream of characters
- Shortest palindrome

### Pattern 6: Sweep Line
Process events in sorted order.

**Examples**:
- Skyline problem
- Meeting rooms III
- Rectangle area

### Pattern 7: State Machine DP
Define states and transitions explicitly.

**Examples**:
- Best time to buy and sell stock with cooldown
- Best time to buy and sell stock IV
- Regular expression matching

## Complexity Requirements

Hard problems often require:
- **Time**: O(n log n) or better for large inputs
- **Space**: Often O(n) or O(1) optimization needed
- Must handle edge cases efficiently
- Sometimes multiple passes with different techniques

## Problem Difficulty Levels within Hard

### Hard Level 1 (Accessible)
- Clear problem statement
- Known pattern with twist
- 45-60 minutes for experienced solver

**Examples**:
- Trapping rain water
- Binary tree maximum path sum
- Word break II

### Hard Level 2 (Challenging)
- Less obvious approach
- Multiple techniques combined
- 60-90 minutes

**Examples**:
- Median of two sorted arrays
- Regular expression matching
- Alien dictionary

### Hard Level 3 (Very Challenging)
- Novel insights required
- Advanced algorithms
- 90+ minutes or research needed

**Examples**:
- Shortest palindrome
- Create maximum number
- Count of range sum

## Recommended Practice Order

### Phase 1: Accessible Hard Problems
Start with hard problems that use familiar patterns:
1. Trapping rain water (two pointers)
2. Longest valid parentheses (stack/DP)
3. Binary tree maximum path sum (recursion)
4. Word ladder II (BFS + backtracking)

### Phase 2: DP-Heavy Problems
Master complex dynamic programming:
1. Edit distance
2. Regular expression matching
3. Interleaving strings
4. Distinct subsequences

### Phase 3: Advanced Algorithms
Tackle problems requiring specialized techniques:
1. Median of two sorted arrays (binary search)
2. Sliding window maximum (monotonic deque)
3. Largest rectangle in histogram (monotonic stack)
4. Shortest palindrome (KMP)

### Phase 4: System Design Style
Complex data structure design:
1. LFU Cache
2. All O(1) data structure
3. Design search autocomplete system

## Interview Preparation

### Expected Skill Level
- Can solve 30-50% of hard problems
- Familiar with advanced patterns
- Can discuss multiple approaches
- Explain time/space complexity clearly

### During Interview
1. **Clarify extensively**: Edge cases, constraints, examples
2. **Think out loud**: Share your thought process
3. **Start with brute force**: Show you can get a solution
4. **Optimize iteratively**: Don't jump to optimal immediately
5. **Code carefully**: Hard problems have more edge cases
6. **Test thoroughly**: Walk through multiple test cases
7. **Discuss tradeoffs**: Time vs space, readability vs performance

### Red Flags to Avoid
- Jumping to code without clear plan
- Ignoring edge cases
- Not testing solution
- Getting stuck without asking clarifying questions
- Not discussing complexity

## Time Management

- **15 min**: Understand problem, clarify, discuss approach
- **40 min**: Implement solution
- **5 min**: Test and verify

If stuck after 20 minutes, ask for hints or move to simpler approach.

## Learning Resources

### Online Judges
- LeetCode (Hard filter)
- Codeforces (Div 1 problems)
- TopCoder (Div 1 problems)
- AtCoder (ABC/ARC hard problems)

### Study Materials
- Algorithm books (CLRS, Algorithm Design Manual)
- Competitive programming handbooks
- System design resources for design problems

### Practice Strategies
- Virtual contests (time pressure)
- Topic-focused practice (all DP hard, all graph hard)
- Company-specific problem lists
- Mock interviews with peers

## Success Metrics

### Beginner (Hard Problems)
- Solve 1 hard problem per week
- Need hints for most problems
- Take 90+ minutes

### Intermediate
- Solve 2-3 hard problems per week
- Can solve 30% without hints
- 60-90 minutes average

### Advanced
- Solve 5+ hard problems per week
- Can solve 60% without hints
- 45-60 minutes average

## Tips for Mastery

1. **Don't rush**: Hard problems require deep thinking
2. **Learn from editorial**: Understand the insights, not just code
3. **Implement multiple times**: First with help, then from memory
4. **Teach others**: Explain solutions to solidify understanding
5. **Track patterns**: Note which techniques appear frequently
6. **Stay persistent**: Hard problems are meant to be challenging
7. **Build foundation**: Strong medium-level skills make hard easier

## Common Pitfalls

- Attempting hard problems too early (without medium mastery)
- Memorizing solutions instead of understanding
- Not revisiting problems (active recall crucial)
- Giving up too quickly (vs. spending too long stuck)
- Ignoring time/space complexity analysis
- Not considering all edge cases

## Mental Approach

- **Growth mindset**: Every hard problem teaches something
- **Patience**: Mastery takes months/years of practice
- **Reflection**: After solving, think about what made it hard
- **Pattern building**: Connect new problems to ones you've solved
- **Accept struggle**: It's part of the learning process

---

Hard problems separate good from great. Focus on understanding deeply rather than solving quickly. Quality over quantity is key at this level.
