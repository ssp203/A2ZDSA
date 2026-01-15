# Greedy Algorithms

This directory contains greedy algorithm implementations.

## What is Greedy Algorithm?

A greedy algorithm makes locally optimal choices at each step with the hope of finding a global optimum. It builds solution piece by piece, always choosing the next piece that offers the most immediate benefit.

**Key Characteristics**:
1. **Greedy Choice Property**: Local optimal choice leads to global optimal solution
2. **Optimal Substructure**: Optimal solution contains optimal solutions to subproblems
3. **No Backtracking**: Once a choice is made, it's never reconsidered

## Greedy vs Dynamic Programming

| Aspect | Greedy | Dynamic Programming |
|--------|--------|---------------------|
| Choice | Local optimum | All possibilities |
| Reconsideration | Never | May reconsider |
| Complexity | Usually lower | Usually higher |
| Guarantee | Not always optimal | Always optimal |
| Example | Dijkstra's | Bellman-Ford |

## When to Use Greedy?

✓ Problem exhibits greedy choice property  
✓ Local optimum leads to global optimum  
✓ Problem has optimal substructure  
✓ No need to reconsider previous choices  

Common problem phrases:
- "Maximize/minimize"
- "Earliest/latest"
- "Shortest/longest"
- "Fewest/most"

## Classic Greedy Problems

### Activity Selection
- Meeting rooms
- Non-overlapping intervals
- Maximum non-overlapping intervals
- Minimum platforms required

### Array Problems
- Jump game
- Gas station
- Candy distribution
- Remove K digits
- Minimum number of arrows to burst balloons

### String Problems
- Remove duplicate letters
- Smallest subsequence
- Partition labels

### Scheduling Problems
- Job sequencing with deadlines
- Minimum waiting time
- Task scheduler

### Mathematical Problems
- Assign cookies
- Minimum number of coins
- Fractional knapsack
- Egyptian fraction

### Graph Algorithms (Greedy)
- Dijkstra's shortest path
- Prim's minimum spanning tree
- Kruskal's minimum spanning tree
- Huffman coding

## Problem-Solving Strategy

### Step 1: Identify Greedy Choice
What local decision leads to optimal solution?
- Sort by some criteria
- Always pick largest/smallest
- Always pick earliest/latest

### Step 2: Prove Greedy Choice Property
Can you prove local optimal → global optimal?
- Exchange argument
- Induction
- Contradiction

### Step 3: Demonstrate Optimal Substructure
Does optimal solution contain optimal subproblem solutions?

### Step 4: Implement
- Usually involves sorting
- Iterate and make greedy choices
- Track necessary state

## Example: Activity Selection

**Problem**: Given start and end times of activities, select maximum number of non-overlapping activities.

**Greedy Choice**: Always pick the activity that finishes earliest.

```java
/**
 * Activity Selection Problem
 * Time Complexity: O(n log n) - for sorting
 * Space Complexity: O(1)
 */
public static int maxActivities(int[] start, int[] end) {
    int n = start.length;
    
    // Create array of activities with start and end times
    int[][] activities = new int[n][2];
    for (int i = 0; i < n; i++) {
        activities[i][0] = start[i];
        activities[i][1] = end[i];
    }
    
    // Sort by end time (greedy choice)
    Arrays.sort(activities, (a, b) -> a[1] - b[1]);
    
    int count = 1;
    int lastEnd = activities[0][1];
    
    for (int i = 1; i < n; i++) {
        // If current activity starts after last selected ends
        if (activities[i][0] >= lastEnd) {
            count++;
            lastEnd = activities[i][1];
        }
    }
    
    return count;
}
```

## Common Greedy Patterns

### Pattern 1: Interval Scheduling
- Sort intervals by end time
- Greedily select non-overlapping intervals

### Pattern 2: Two-Pointer
- Sort array
- Use two pointers to make greedy decisions
- Example: Assign cookies, boats to save people

### Pattern 3: Priority Queue/Heap
- Always pick max/min element
- Example: Meeting rooms II, task scheduler

### Pattern 4: Sort + Greedy Choice
- Sort by some criteria
- Make locally optimal choice
- Example: Minimum arrows, gas station

## Proof Techniques

### 1. Exchange Argument
Show that swapping greedy choice with another doesn't worsen solution.

### 2. Stay Ahead
Show that greedy algorithm's solution is always ≥ optimal at every step.

### 3. Structural
Prove by contradiction or induction that greedy choice is safe.

## Common Mistakes

- Assuming greedy works without proof
- Not considering all possible greedy strategies
- Wrong sorting criteria
- Not handling edge cases
- Forgetting to check if greedy actually produces optimal solution

## Interview Tips

1. **Identify the pattern**: Look for maximization/minimization with constraints
2. **Sort first**: Many greedy problems start with sorting
3. **Explain your greedy choice**: Why is this locally optimal?
4. **Provide counterexample for non-greedy approaches**: Show why other choices fail
5. **Discuss complexity**: Greedy is often O(n log n) due to sorting
6. **Edge cases**: Empty input, single element, all same values

## Practice Problems by Difficulty

### Easy
- Assign Cookies
- Lemonade Change
- Maximum Units on a Truck
- Minimum Cost to Move Chips

### Medium
- Jump Game
- Jump Game II
- Gas Station
- Boats to Save People
- Partition Labels
- Minimum Number of Arrows to Burst Balloons
- Non-overlapping Intervals

### Hard
- Candy
- Remove Duplicate Letters
- Create Maximum Number
- Smallest Range Covering Elements from K Lists

## When Greedy Fails

Greedy doesn't work for:
- 0/1 Knapsack (need DP)
- Longest common subsequence (need DP)
- Matrix chain multiplication (need DP)
- Graphs with negative weights (need Bellman-Ford, not Dijkstra)

Always verify that greedy choice property holds for your specific problem!
