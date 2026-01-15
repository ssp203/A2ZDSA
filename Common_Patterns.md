# Common DSA Patterns & Templates in Java

This guide contains frequently used patterns and code templates for solving DSA problems efficiently.

---

## 1. Two Pointers Pattern

### Pattern: Opposite Direction
```java
// Used in: Palindrome, Two Sum in sorted array, Container with most water
public void twoPointers(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        // Process elements at left and right
        if (condition) {
            left++;
        } else {
            right--;
        }
    }
}
```

### Pattern: Same Direction (Fast & Slow)
```java
// Used in: Remove duplicates, Move zeros, Partition array
public void fastSlowPointers(int[] arr) {
    int slow = 0;
    for (int fast = 0; fast < arr.length; fast++) {
        if (shouldIncludeFast) {
            arr[slow] = arr[fast];
            slow++;
        }
    }
}
```

### Pattern: Linked List Cycle Detection
```java
// Floyd's Cycle Detection (Tortoise and Hare)
public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

---

## 2. Sliding Window Pattern

### Pattern: Fixed Window Size
```java
// Used in: Maximum sum of subarray of size K
public int fixedSlidingWindow(int[] arr, int k) {
    int windowSum = 0;
    int maxSum = 0;
    
    // First window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide the window
    for (int i = k; i < arr.length; i++) {
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

### Pattern: Variable Window Size
```java
// Used in: Longest substring with K distinct characters
public int variableSlidingWindow(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int maxLen = 0;
    
    for (int right = 0; right < s.length(); right++) {
        // Expand window
        char c = s.charAt(right);
        map.put(c, map.getOrDefault(c, 0) + 1);
        
        // Shrink window if needed
        while (map.size() > k) {
            char leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            left++;
        }
        
        maxLen = Math.max(maxLen, right - left + 1);
    }
    
    return maxLen;
}
```

---

## 3. Binary Search Patterns

### Pattern: Basic Binary Search
```java
public int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;  // Avoid overflow
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1;  // Not found
}
```

### Pattern: Find First/Last Occurrence
```java
// Find first occurrence (leftmost)
public int findFirst(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    int result = -1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            result = mid;
            right = mid - 1;  // Continue searching left
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result;
}
```

### Pattern: Search in Rotated Array
```java
public int searchRotated(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        
        // Left half is sorted
        if (arr[left] <= arr[mid]) {
            if (target >= arr[left] && target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // Right half is sorted
        else {
            if (target > arr[mid] && target <= arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    
    return -1;
}
```

---

## 4. Backtracking Pattern

### General Template
```java
public void backtrack(List<Integer> current, int start) {
    // Base case - found valid solution
    if (isValidSolution(current)) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    // Try all possibilities
    for (int i = start; i < candidates.length; i++) {
        // Make choice
        current.add(candidates[i]);
        
        // Explore with this choice
        backtrack(current, i + 1);
        
        // Undo choice (backtrack)
        current.remove(current.size() - 1);
    }
}
```

### Pattern: Permutations
```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrackPermute(nums, new ArrayList<>(), result);
    return result;
}

private void backtrackPermute(int[] nums, List<Integer> current, 
                              List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    for (int num : nums) {
        if (current.contains(num)) continue;  // Skip used elements
        
        current.add(num);
        backtrackPermute(nums, current, result);
        current.remove(current.size() - 1);
    }
}
```

---

## 5. Dynamic Programming Patterns

### Pattern: 1D DP (Climbing Stairs, House Robber)
```java
public int dpOneDimension(int[] arr) {
    if (arr.length == 0) return 0;
    if (arr.length == 1) return arr[0];
    
    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);
    
    for (int i = 2; i < arr.length; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
    }
    
    return dp[arr.length - 1];
}
```

### Pattern: 2D DP (Grid Path, Longest Common Subsequence)
```java
public int dpTwoDimension(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    
    return dp[m][n];
}
```

### Pattern: DP with Memoization
```java
Map<String, Integer> memo = new HashMap<>();

public int dpMemo(int i, int j) {
    // Base case
    if (i < 0 || j < 0) return 0;
    
    // Check memo
    String key = i + "," + j;
    if (memo.containsKey(key)) {
        return memo.get(key);
    }
    
    // Compute and store
    int result = /* recursive calculation */;
    memo.put(key, result);
    return result;
}
```

---

## 6. Graph Traversal Patterns

### Pattern: DFS (Recursive)
```java
public void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
    visited[node] = true;
    
    // Process current node
    System.out.println(node);
    
    // Visit all neighbors
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited, graph);
        }
    }
}
```

### Pattern: DFS (Iterative with Stack)
```java
public void dfsIterative(int start, List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    Stack<Integer> stack = new Stack<>();
    
    stack.push(start);
    
    while (!stack.isEmpty()) {
        int node = stack.pop();
        
        if (visited[node]) continue;
        visited[node] = true;
        
        // Process node
        System.out.println(node);
        
        // Add neighbors to stack
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                stack.push(neighbor);
            }
        }
    }
}
```

### Pattern: BFS
```java
public void bfs(int start, List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        // Process node
        System.out.println(node);
        
        // Add neighbors to queue
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### Pattern: Topological Sort (Kahn's Algorithm)
```java
public List<Integer> topologicalSort(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    int[] indegree = new int[n];
    
    // Build graph
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        indegree[edge[1]]++;
    }
    
    // BFS with nodes having indegree 0
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }
    
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);
        
        for (int neighbor : graph.get(node)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
    }
    
    return result.size() == n ? result : new ArrayList<>();
}
```

---

## 7. Tree Traversal Patterns

### Pattern: Inorder Traversal (Recursive & Iterative)
```java
// Recursive
public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);
}

// Iterative
public List<Integer> inorderIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }
    
    return result;
}
```

### Pattern: Level Order Traversal
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        result.add(currentLevel);
    }
    
    return result;
}
```

---

## 8. Monotonic Stack Pattern

```java
// Next Greater Element
public int[] nextGreaterElement(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Traverse from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Pop elements smaller than current
        while (!stack.isEmpty() && stack.peek() <= arr[i]) {
            stack.pop();
        }
        
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(arr[i]);
    }
    
    return result;
}
```

---

## 9. Union-Find (Disjoint Set) Pattern

```java
class UnionFind {
    private int[] parent;
    private int[] rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return false;
        
        // Union by rank
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        
        return true;
    }
}
```

---

## 10. Trie Pattern

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
    
    private TrieNode searchNode(String str) {
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
```

---

## Quick Reference: Time Complexities

| Operation | Array | LinkedList | Stack | Queue | HashMap | TreeMap | Heap |
|-----------|-------|------------|-------|-------|---------|---------|------|
| Access | O(1) | O(n) | O(n) | O(n) | O(1) | O(log n) | O(n) |
| Search | O(n) | O(n) | O(n) | O(n) | O(1) | O(log n) | O(n) |
| Insert | O(n) | O(1) | O(1) | O(1) | O(1) | O(log n) | O(log n) |
| Delete | O(n) | O(1) | O(1) | O(1) | O(1) | O(log n) | O(log n) |

---

## Tips for Pattern Recognition

1. **Two Pointers:** Sorted array, finding pairs, palindrome
2. **Sliding Window:** Contiguous subarray/substring problems
3. **Binary Search:** Sorted data, searching in range
4. **Backtracking:** Combinations, permutations, subsets
5. **DP:** Optimization problems, counting ways
6. **BFS:** Shortest path, level-order traversal
7. **DFS:** Path finding, connectivity, cycles
8. **Monotonic Stack:** Next greater/smaller element
9. **Union-Find:** Connected components, cycle detection

---

Keep this guide handy while solving problems. Understanding these patterns will help you recognize solutions faster!
