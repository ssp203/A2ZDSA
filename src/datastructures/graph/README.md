# Graph

This directory contains graph data structure representations and implementations.

## What is a Graph?

A graph is a non-linear data structure consisting of vertices (nodes) and edges connecting them.

**Components**:
- **Vertices (V)**: Nodes in the graph
- **Edges (E)**: Connections between vertices

## Types of Graphs

### 1. Directed vs Undirected
- **Directed**: Edges have direction (A → B)
- **Undirected**: Edges have no direction (A — B)

### 2. Weighted vs Unweighted
- **Weighted**: Edges have weights/costs
- **Unweighted**: All edges have same weight

### 3. Cyclic vs Acyclic
- **Cyclic**: Contains at least one cycle
- **Acyclic**: No cycles (DAG - Directed Acyclic Graph)

### 4. Connected vs Disconnected
- **Connected**: Path exists between any two vertices
- **Disconnected**: Some vertices unreachable from others

## Graph Representations

### 1. Adjacency Matrix
2D array where `matrix[i][j]` represents edge from i to j.

```java
int[][] graph = new int[V][V];
// graph[i][j] = 1 if edge exists (unweighted)
// graph[i][j] = weight (weighted)
// graph[i][j] = 0 if no edge
```

**Pros**:
- O(1) edge lookup
- Simple implementation

**Cons**:
- O(V²) space
- Inefficient for sparse graphs

**Best for**: Dense graphs, frequent edge queries

### 2. Adjacency List
Array/HashMap of lists, where each index/key stores neighbors.

```java
// Using ArrayList
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < V; i++) {
    graph.add(new ArrayList<>());
}
graph.get(u).add(v); // Add edge u -> v

// Using HashMap
Map<Integer, List<Integer>> graph = new HashMap<>();

// For weighted graphs
class Edge {
    int dest, weight;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}
List<List<Edge>> graph = new ArrayList<>();
```

**Pros**:
- O(V + E) space
- Efficient for sparse graphs
- Fast neighbor iteration

**Cons**:
- O(degree) edge lookup
- Slightly more complex

**Best for**: Sparse graphs (most real-world graphs)

### 3. Edge List
List of all edges.

```java
class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
List<Edge> edges = new ArrayList<>();
```

**Best for**: Algorithms like Kruskal's MST

## Graph Construction from Input

```java
// From edge list
int n = 5; // number of vertices
int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}};

// Build adjacency list
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}

for (int[] edge : edges) {
    int u = edge[0], v = edge[1];
    graph.get(u).add(v);
    graph.get(v).add(u); // For undirected graph
}
```

## Graph Terminology

- **Degree**: Number of edges connected to a vertex
  - **In-degree**: Incoming edges (directed graph)
  - **Out-degree**: Outgoing edges (directed graph)
- **Path**: Sequence of vertices connected by edges
- **Cycle**: Path that starts and ends at same vertex
- **Connected Component**: Maximal set of connected vertices
- **Strongly Connected**: Every vertex reachable from every other (directed graphs)
- **Bipartite**: Vertices can be divided into two sets with edges only between sets

## Common Graph Patterns

See the algorithms/graph directory for detailed algorithm implementations and patterns for:
- BFS and DFS traversals
- Shortest path algorithms (Dijkstra, Bellman-Ford)
- Minimum spanning tree (Kruskal, Prim)
- Topological sort
- Cycle detection
- Union-Find
- And more...

## Simple Example Implementations

### Basic Graph Class
```java
class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list
    
    Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    
    void addEdgeUndirected(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    List<Integer> getNeighbors(int v) {
        return adj.get(v);
    }
    
    int getVertexCount() {
        return V;
    }
}
```

### Weighted Graph
```java
class WeightedGraph {
    private int V;
    private List<List<Edge>> adj;
    
    class Edge {
        int dest, weight;
        Edge(int d, int w) {
            dest = d;
            weight = w;
        }
    }
    
    WeightedGraph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    
    void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(dest, weight));
    }
    
    void addEdgeUndirected(int u, int v, int weight) {
        adj.get(u).add(new Edge(v, weight));
        adj.get(v).add(new Edge(u, weight));
    }
}
```

## Space Complexity Comparison

| Representation | Space | Edge Lookup | Get All Neighbors |
|----------------|-------|-------------|-------------------|
| Adjacency Matrix | O(V²) | O(1) | O(V) |
| Adjacency List | O(V+E) | O(degree) | O(degree) |
| Edge List | O(E) | O(E) | O(E) |

## When to Use Each Representation

### Adjacency Matrix
✓ Dense graphs (E ≈ V²)  
✓ Need O(1) edge lookup  
✓ Small graphs  
✗ Sparse graphs (wastes space)

### Adjacency List
✓ Sparse graphs (most common)  
✓ Need to iterate over neighbors  
✓ Space efficiency important  
✗ Frequent "is there edge?" queries

### Edge List
✓ Kruskal's algorithm  
✓ Simple edge processing  
✗ Finding neighbors

## Interview Tips

1. **Clarify representation**: Ask if graph is given as adjacency list, matrix, or edges
2. **Ask about properties**: Directed? Weighted? Can have cycles?
3. **Clarify constraints**: Number of vertices, edges, weight ranges
4. **Choose representation**: Usually adjacency list unless told otherwise
5. **Handle disconnected graphs**: May need to iterate through all vertices
6. **Watch for cycles**: Especially important in directed graphs
7. **Consider BFS vs DFS**: BFS for shortest path, DFS for connectivity

## Common Mistakes

- Not handling disconnected components
- Wrong graph representation for problem
- Not checking if vertex exists
- Forgetting to mark visited nodes
- Adding edges incorrectly for undirected graphs
- Not considering negative weights
- Assuming graph is connected

## Practice Tips

1. Start with graph representation and construction
2. Master BFS and DFS (see algorithms/graph)
3. Practice on small graphs (5-7 nodes)
4. Draw the graph before coding
5. Understand when to use which representation
6. Learn to convert between representations if needed

## Related Topics

Refer to `src/algorithms/graph/` for:
- Graph traversal algorithms (BFS, DFS)
- Shortest path algorithms
- Minimum spanning tree
- Topological sort
- Cycle detection
- Connected components
- And more graph algorithms

This directory focuses on **graph representation and basic operations**, while algorithmic implementations are in the algorithms/graph directory.
