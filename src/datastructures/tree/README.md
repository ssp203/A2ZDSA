# Trees

This directory contains tree data structure implementations and problem solutions.

## What is a Tree?

A tree is a hierarchical data structure consisting of nodes connected by edges. One node is designated as the root, and every other node is connected by exactly one path from the root.

**Key Properties**:
- One root node
- Each node has zero or more child nodes
- No cycles
- N nodes have N-1 edges

## Tree Terminology

- **Root**: Top node with no parent
- **Parent**: Node with children
- **Child**: Node with a parent
- **Leaf**: Node with no children
- **Internal Node**: Node with at least one child
- **Depth**: Length of path from root to node
- **Height**: Length of longest path from node to leaf
- **Level**: Depth + 1
- **Subtree**: Tree formed by a node and its descendants
- **Degree**: Number of children of a node

## Binary Tree

A tree where each node has at most two children (left and right).

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

### Types of Binary Trees

1. **Full Binary Tree**: Every node has 0 or 2 children
2. **Complete Binary Tree**: All levels filled except possibly last, filled left to right
3. **Perfect Binary Tree**: All internal nodes have 2 children, all leaves at same level
4. **Balanced Binary Tree**: Height difference between left and right subtrees ≤ 1
5. **Degenerate Tree**: Each parent has only one child (essentially a linked list)

## Tree Traversals

### 1. Depth-First Search (DFS)

#### Inorder (Left-Root-Right)
```java
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
// For BST: Gives sorted order
```

#### Preorder (Root-Left-Right)
```java
void preorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
// Use: Create copy, prefix expression
```

#### Postorder (Left-Right-Root)
```java
void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
// Use: Delete tree, postfix expression
```

### 2. Breadth-First Search (BFS)

#### Level Order
```java
void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.val + " ");
        
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

## Binary Search Tree (BST)

A binary tree where:
- Left subtree contains values less than root
- Right subtree contains values greater than root
- Left and right subtrees are also BSTs

### BST Operations

```java
// Search - O(h) where h is height
TreeNode search(TreeNode root, int val) {
    if (root == null || root.val == val) return root;
    if (val < root.val) return search(root.left, val);
    return search(root.right, val);
}

// Insert - O(h)
TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    }
    return root;
}

// Delete - O(h)
TreeNode delete(TreeNode root, int val) {
    if (root == null) return null;
    
    if (val < root.val) {
        root.left = delete(root.left, val);
    } else if (val > root.val) {
        root.right = delete(root.right, val);
    } else {
        // Node found
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        
        // Node has two children
        TreeNode minNode = findMin(root.right);
        root.val = minNode.val;
        root.right = delete(root.right, minNode.val);
    }
    return root;
}

TreeNode findMin(TreeNode node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}
```

## AVL Tree (Self-Balancing BST)

Maintains height balance: |height(left) - height(right)| ≤ 1

**Rotations**:
- Left Rotation
- Right Rotation
- Left-Right Rotation
- Right-Left Rotation

**Time Complexity**: O(log n) for search, insert, delete

## Common Tree Patterns

### Pattern 1: Recursive Traversal
Most tree problems can be solved recursively.

```java
// Template
ReturnType solve(TreeNode root) {
    // Base case
    if (root == null) return baseValue;
    
    // Recursive calls
    ReturnType left = solve(root.left);
    ReturnType right = solve(root.right);
    
    // Combine results
    return combine(root.val, left, right);
}
```

### Pattern 2: Level Order with Queue
Process tree level by level.

```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
```

### Pattern 3: Path Problems
Track path from root to node.

```java
boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    
    // Leaf node
    if (root.left == null && root.right == null) {
        return sum == root.val;
    }
    
    int remaining = sum - root.val;
    return hasPathSum(root.left, remaining) || 
           hasPathSum(root.right, remaining);
}
```

### Pattern 4: Subtree Problems
Process subtrees independently.

```java
boolean isBalanced(TreeNode root) {
    return height(root) != -1;
}

int height(TreeNode root) {
    if (root == null) return 0;
    
    int left = height(root.left);
    if (left == -1) return -1;
    
    int right = height(root.right);
    if (right == -1) return -1;
    
    if (Math.abs(left - right) > 1) return -1;
    
    return Math.max(left, right) + 1;
}
```

## Classic Problems

### Easy
- Maximum depth of binary tree
- Minimum depth of binary tree
- Invert binary tree
- Symmetric tree
- Same tree
- Path sum
- Binary tree paths
- Diameter of binary tree
- Balanced binary tree
- Merge two binary trees

### Medium
- Binary tree level order traversal
- Binary tree zigzag level order traversal
- Validate binary search tree
- Kth smallest element in BST
- Lowest common ancestor of BST
- Binary tree right side view
- Count complete tree nodes
- Path sum II
- Construct binary tree from preorder and inorder
- Flatten binary tree to linked list
- Populating next right pointers

### Hard
- Binary tree maximum path sum
- Serialize and deserialize binary tree
- Recover binary search tree
- Binary tree postorder traversal (iterative)
- Vertical order traversal

## Time Complexities

### Binary Tree
| Operation | Average | Worst |
|-----------|---------|-------|
| Search | O(n) | O(n) |
| Insert | O(n) | O(n) |
| Delete | O(n) | O(n) |
| Space | O(n) | O(n) |

### BST
| Operation | Average | Worst | Best (Balanced) |
|-----------|---------|-------|-----------------|
| Search | O(h) | O(n) | O(log n) |
| Insert | O(h) | O(n) | O(log n) |
| Delete | O(h) | O(n) | O(log n) |

h = height of tree

### AVL Tree
All operations: O(log n) guaranteed

## Advanced Topics

- **Segment Tree**: Range queries and updates
- **Fenwick Tree (BIT)**: Prefix sums and range queries
- **Trie (Prefix Tree)**: String operations
- **Red-Black Tree**: Self-balancing BST
- **B-Tree**: Disk-based balanced tree
- **Suffix Tree**: String matching

## Interview Tips

1. **Draw it**: Visualize with small tree (3-7 nodes)
2. **Base case first**: What if root is null?
3. **Trust recursion**: Assume recursive calls work
4. **Return type**: What should function return?
5. **Edge cases**: Empty tree, single node, skewed tree
6. **Complexity**: Consider height vs number of nodes
7. **DFS vs BFS**: Choose based on problem requirements

## Common Mistakes

- Not handling null nodes
- Forgetting leaf node check
- Modifying tree structure accidentally
- Wrong traversal order
- Not considering skewed trees
- Integer overflow in height/diameter calculations
- Not maintaining BST property during modifications

## DFS vs BFS

| Aspect | DFS | BFS |
|--------|-----|-----|
| Data Structure | Stack (recursion) | Queue |
| Memory | O(h) | O(w) |
| Use Case | Search, paths | Shortest path, levels |
| Implementation | Simpler (recursive) | Iterative with queue |

h = height, w = maximum width

## Practice Strategy

1. Master three DFS traversals (inorder, preorder, postorder)
2. Learn BFS level order traversal
3. Practice recursive solutions (most common)
4. Understand BST operations
5. Solve path and subtree problems
6. Learn construction and serialization
7. Move to advanced structures (Segment Tree, Trie)
