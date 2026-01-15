# Queue

This directory contains queue implementations and problem solutions.

## What is a Queue?

A Queue is a linear data structure that follows the **First In First Out (FIFO)** principle. The first element added is the first one to be removed.

**Real-world analogy**: Line at ticket counter, printer queue, customer service

## Basic Operations

```java
// Using Java's Queue interface
Queue<Integer> queue = new LinkedList<>();

// Enqueue: Add element to rear - O(1)
queue.offer(10);  // or queue.add(10)

// Dequeue: Remove and return front element - O(1)
int front = queue.poll();  // or queue.remove()

// Peek: View front element without removing - O(1)
int frontElement = queue.peek();  // or queue.element()

// isEmpty: Check if queue is empty - O(1)
boolean empty = queue.isEmpty();

// size: Get number of elements - O(1)
int size = queue.size();
```

## Types of Queues

### 1. Simple Queue (Linear Queue)
Basic FIFO queue.

### 2. Circular Queue
Last position connects back to first position. Efficient use of space.

```java
class CircularQueue {
    private int[] arr;
    private int front, rear, size, capacity;
    
    CircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        front = size = 0;
        rear = k - 1;
    }
    
    boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        return true;
    }
    
    boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    int Front() {
        return isEmpty() ? -1 : arr[front];
    }
    
    int Rear() {
        return isEmpty() ? -1 : arr[rear];
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    boolean isFull() {
        return size == capacity;
    }
}
```

### 3. Priority Queue (Heap)
Elements are dequeued based on priority, not FIFO order.

```java
// Min Heap (default)
PriorityQueue<Integer> minPQ = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

// Custom comparator
PriorityQueue<Task> pq = new PriorityQueue<>(
    (a, b) -> a.priority - b.priority
);
```

**Time Complexities**:
- Insert: O(log n)
- Remove: O(log n)
- Peek: O(1)

### 4. Deque (Double-Ended Queue)
Can insert/remove from both ends.

```java
Deque<Integer> deque = new ArrayDeque<>();

// Add to front/rear
deque.addFirst(1);
deque.addLast(2);

// Remove from front/rear
deque.removeFirst();
deque.removeLast();

// Peek front/rear
deque.peekFirst();
deque.peekLast();
```

## Implementation Methods

### Using Array
```java
class QueueArray {
    private int[] arr;
    private int front, rear, size, capacity;
    
    QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    void enqueue(int x) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }
    
    int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
}
```

### Using Linked List
```java
class QueueLinkedList {
    private Node front, rear;
    
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    
    void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    
    int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    
    boolean isEmpty() {
        return front == null;
    }
}
```

## Common Queue Patterns

### Pattern 1: Level Order Traversal (BFS)
Process elements level by level.

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

**Problems**:
- Binary tree level order traversal
- Binary tree zigzag level order traversal
- Binary tree right side view
- Average of levels in binary tree
- Shortest path in binary matrix

### Pattern 2: Sliding Window with Queue
Maintain elements in a window using deque.

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];
    
    for (int i = 0; i < nums.length; i++) {
        // Remove elements outside window
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        
        // Remove smaller elements (maintain decreasing order)
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }
        
        deque.offerLast(i);
        
        // Add to result
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }
    
    return result;
}
```

**Problems**:
- Sliding window maximum
- Sliding window median
- Shortest subarray with sum at least K

### Pattern 3: Two Stacks as Queue
Implement queue using two stacks.

```java
class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    
    MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    void push(int x) {
        input.push(x);
    }
    
    int pop() {
        peek(); // Transfer if needed
        return output.pop();
    }
    
    int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
```

### Pattern 4: Priority Queue for Top K
Use heap to maintain top K elements.

```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    return minHeap.peek();
}
```

**Problems**:
- Kth largest element
- Top K frequent elements
- K closest points to origin
- Merge K sorted lists
- Find median from data stream

## Classic Problems

### Easy
- Design circular queue
- Implement queue using stacks
- Number of recent calls
- First unique character in a string
- Moving average from data stream

### Medium
- Binary tree level order traversal
- Binary tree zigzag level order traversal
- Rotting oranges
- Open the lock
- Perfect squares
- Walls and gates
- Design hit counter
- Task scheduler
- Top K frequent elements
- Sliding window maximum

### Hard
- Sliding window median
- Find median from data stream
- Shortest path visiting all nodes
- Serialize and deserialize binary tree

## Applications

1. **Operating Systems**: Process scheduling, CPU scheduling
2. **Networks**: Data packet routing, print spooling
3. **Breadth-First Search**: Graph traversal, shortest path
4. **Level Order Traversal**: Trees and graphs
5. **Asynchronous Data Transfer**: IO Buffers, file IO, pipes
6. **Simulation**: Modeling real-world queues

## Time & Space Complexity

| Operation | Array | Linked List |
|-----------|-------|-------------|
| Enqueue | O(1) | O(1) |
| Dequeue | O(1) | O(1) |
| Peek | O(1) | O(1) |
| isEmpty | O(1) | O(1) |
| Space | O(n) | O(n) |

## Interview Tips

1. **Recognize FIFO**: Level-by-level processing, BFS
2. **Choose right type**: Simple queue vs Priority queue vs Deque
3. **BFS template**: Most common use case in interviews
4. **Priority queue**: For "top K" and median problems
5. **Deque for sliding window**: When need both ends access
6. **Two stacks trick**: Convert between stack and queue
7. **Level size tracking**: Critical for level order traversal

## Java Collection Framework

```java
// Queue interface implementations
Queue<Integer> linkedListQueue = new LinkedList<>();
Queue<Integer> arrayDequeQueue = new ArrayDeque<>();

// Deque interface
Deque<Integer> deque = new ArrayDeque<>();  // Preferred
Deque<Integer> linkedList = new LinkedList<>();

// Priority Queue
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

**Note**: ArrayDeque is generally faster than LinkedList for queue operations.

## Common Pitfalls

- Not checking if queue is empty before dequeue
- Forgetting to track level size in BFS
- Using wrong type of queue (simple vs priority vs deque)
- Not considering queue overflow in fixed-size implementations
- Confusing offer/poll (returns null) with add/remove (throws exception)

## Practice Strategy

1. Master basic queue operations and implementations
2. Learn BFS template thoroughly (most important!)
3. Practice level order traversal problems
4. Understand priority queue and heap
5. Solve top K problems with priority queue
6. Master deque for sliding window problems
7. Practice converting between stacks and queues
8. Apply queues to graph problems
