# Graph Algorithms

This directory contains graph algorithm implementations.

## Graph Representations

### 1. Adjacency Matrix
```java
int[][] graph = new int[V][V];
// graph[i][j] = weight of edge from i to j
// graph[i][j] = 0 if no edge
```
- Space: O(V²)
- Edge check: O(1)
- Get all neighbors: O(V)
- Good for: Dense graphs

### 2. Adjacency List
```java
List<List<Integer>> graph = new ArrayList<>();
// or
Map<Integer, List<Integer>> graph = new HashMap<>();
```
- Space: O(V + E)
- Edge check: O(degree)
- Get all neighbors: O(degree)
- Good for: Sparse graphs (most common)

### 3. Edge List
```java
class Edge {
    int src, dest, weight;
}
List<Edge> edges = new ArrayList<>();
```
- Good for: Some algorithms like Kruskal's MST

## Core Graph Algorithms

### Traversal Algorithms

#### Breadth-First Search (BFS)
- Uses Queue (FIFO)
- Level-order traversal
- Time: O(V + E), Space: O(V)
- Applications:
  - Shortest path in unweighted graph
  - Level-order traversal
  - Check if graph is bipartite
  - Find all nodes within k distance

#### Depth-First Search (DFS)
- Uses Stack or Recursion (LIFO)
- Goes deep before wide
- Time: O(V + E), Space: O(V)
- Applications:
  - Detect cycle
  - Topological sorting
  - Find connected components
  - Solve maze problems
  - Backtracking problems

### Shortest Path Algorithms

#### Dijkstra's Algorithm
- Finds shortest path from source to all vertices
- Works with non-negative weights
- Uses Priority Queue (greedy)
- Time: O((V + E) log V) with min-heap
- Use for: Single-source shortest path, positive weights

#### Bellman-Ford Algorithm
- Handles negative weight edges
- Detects negative cycles
- Time: O(V × E)
- Use for: Negative weights, detect negative cycles

#### Floyd-Warshall Algorithm
- All-pairs shortest path
- Uses dynamic programming
- Time: O(V³), Space: O(V²)
- Use for: Small graphs, all-pairs shortest path

### Minimum Spanning Tree (MST)

#### Kruskal's Algorithm
- Sorts edges by weight
- Uses Union-Find data structure
- Time: O(E log E)
- Approach: Edge-based, greedy

#### Prim's Algorithm
- Uses Priority Queue
- Starts from any vertex
- Time: O((V + E) log V)
- Approach: Vertex-based, greedy

### Topological Sort
- Linear ordering of vertices in DAG
- Used in: Task scheduling, course prerequisites
- Algorithms:
  - DFS-based: O(V + E)
  - Kahn's algorithm (BFS-based): O(V + E)

### Cycle Detection

#### Undirected Graph
- DFS with parent tracking
- Union-Find

#### Directed Graph
- DFS with three colors (white/gray/black)
- Topological sort (Kahn's algorithm)

### Connected Components

#### Undirected Graph
- DFS or BFS
- Union-Find

#### Directed Graph
- Kosaraju's algorithm (Strongly Connected Components)
- Tarjan's algorithm (Strongly Connected Components)

### Advanced Algorithms

- **Articulation Points & Bridges**: Find critical connections
- **Bipartite Check**: Two-coloring with BFS/DFS
- **Eulerian Path/Circuit**: Visit every edge exactly once
- **Hamiltonian Path**: Visit every vertex exactly once (NP-complete)
- **Maximum Flow**: Ford-Fulkerson, Edmonds-Karp
- **Minimum Cut**: Max-Flow Min-Cut theorem

## Problem Categories

### 1. Basic Traversal
- Number of islands
- Clone graph
- Pacific Atlantic water flow
- Surrounded regions

### 2. Shortest Path
- Network delay time
- Cheapest flights within K stops
- Path with minimum effort
- Shortest path in binary matrix

### 3. Topological Sort
- Course schedule
- Course schedule II
- Alien dictionary
- Sequence reconstruction

### 4. Union-Find
- Number of connected components
- Redundant connection
- Accounts merge
- Smallest string with swaps

### 5. Minimum Spanning Tree
- Min cost to connect all points
- Optimize water distribution

### 6. Advanced
- Critical connections
- Reconstruct itinerary
- Word ladder
- Word ladder II

## Common Patterns

### Pattern 1: BFS for Shortest Path
```java
Queue<Integer> queue = new LinkedList<>();
boolean[] visited = new boolean[n];
int[] distance = new int[n];

queue.offer(start);
visited[start] = true;
distance[start] = 0;

while (!queue.isEmpty()) {
    int node = queue.poll();
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            distance[neighbor] = distance[node] + 1;
            queue.offer(neighbor);
        }
    }
}
```

### Pattern 2: DFS for Cycle Detection
```java
boolean hasCycle(int node, boolean[] visited, boolean[] recStack) {
    visited[node] = true;
    recStack[node] = true;
    
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            if (hasCycle(neighbor, visited, recStack)) {
                return true;
            }
        } else if (recStack[neighbor]) {
            return true; // Back edge found
        }
    }
    
    recStack[node] = false;
    return false;
}
```

### Pattern 3: Union-Find Template
```java
class UnionFind {
    int[] parent, rank;
    
    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
    
    boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) return false;
        
        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
```

## Interview Tips

1. **Clarify graph representation**: Directed/undirected? Weighted? Cyclic?
2. **Choose right algorithm**: BFS for shortest path, DFS for connectivity
3. **Watch for cycles**: Especially in directed graphs
4. **Handle disconnected graphs**: May need to iterate through all nodes
5. **Space complexity**: Remember to count visited array and recursion stack
6. **Edge cases**: Empty graph, single node, disconnected components

## Common Mistakes

- Not handling disconnected components
- Forgetting to mark nodes as visited
- Wrong graph representation choice
- Not checking for cycles when needed
- Incorrect base case in recursion
- Modifying graph during traversal

## Practice Strategy

1. Master BFS and DFS first (most important)
2. Learn to detect cycles in both directed and undirected graphs
3. Practice shortest path algorithms
4. Understand topological sort
5. Learn Union-Find for connectivity problems
6. Move to advanced algorithms (MST, strongly connected components)
