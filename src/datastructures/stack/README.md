# Stack

This directory contains stack implementations and problem solutions.

## What is a Stack?

A Stack is a linear data structure that follows the **Last In First Out (LIFO)** principle. The last element added is the first one to be removed.

**Real-world analogy**: Stack of plates, browser back button, undo operation

## Basic Operations

```java
// Using Java's Stack class
Stack<Integer> stack = new Stack<>();

// Push: Add element to top - O(1)
stack.push(10);

// Pop: Remove and return top element - O(1)
int top = stack.pop();

// Peek: View top element without removing - O(1)
int topElement = stack.peek();

// isEmpty: Check if stack is empty - O(1)
boolean empty = stack.isEmpty();

// size: Get number of elements - O(1)
int size = stack.size();
```

## Implementation Methods

### 1. Using Array
```java
class ArrayStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    ArrayStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    void push(int x) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++top] = x;
    }
    
    int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }
    
    int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }
    
    boolean isEmpty() {
        return top == -1;
    }
}
```

**Pros**: Simple, cache-friendly  
**Cons**: Fixed size, may waste space

### 2. Using Linked List
```java
class LinkedListStack {
    private Node top;
    
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    
    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }
    
    int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        return data;
    }
    
    int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    boolean isEmpty() {
        return top == null;
    }
}
```

**Pros**: Dynamic size, no wasted space  
**Cons**: Extra memory for pointers, not cache-friendly

## Common Stack Patterns

### Pattern 1: Monotonic Stack
Stack that maintains elements in monotonic order (increasing or decreasing).

**Template**:
```java
public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    // Traverse from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Pop elements smaller than current
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        
        // Stack top is the next greater element
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        
        // Push current element
        stack.push(nums[i]);
    }
    
    return result;
}
```

**Problems**:
- Next greater element
- Next smaller element
- Daily temperatures
- Largest rectangle in histogram
- Trapping rain water

### Pattern 2: Expression Evaluation
Use stack to evaluate expressions.

**Infix to Postfix**:
```java
public String infixToPostfix(String infix) {
    Stack<Character> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
    
    for (char c : infix.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            result.append(c);
        } else if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                result.append(stack.pop());
            }
            stack.pop(); // Remove '('
        } else { // Operator
            while (!stack.isEmpty() && 
                   precedence(c) <= precedence(stack.peek())) {
                result.append(stack.pop());
            }
            stack.push(c);
        }
    }
    
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }
    
    return result.toString();
}
```

**Problems**:
- Evaluate reverse polish notation
- Basic calculator
- Basic calculator II
- Infix to postfix conversion

### Pattern 3: Balanced Parentheses
Check if brackets are balanced.

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> pairs = new HashMap<>();
    pairs.put(')', '(');
    pairs.put('}', '{');
    pairs.put(']', '[');
    
    for (char c : s.toCharArray()) {
        if (pairs.containsValue(c)) {
            // Opening bracket
            stack.push(c);
        } else if (pairs.containsKey(c)) {
            // Closing bracket
            if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                return false;
            }
        }
    }
    
    return stack.isEmpty();
}
```

**Problems**:
- Valid parentheses
- Minimum add to make parentheses valid
- Minimum remove to make valid parentheses
- Longest valid parentheses

### Pattern 4: Stack with Special Operations
Implement stack with additional features.

**Min Stack**:
```java
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    int top() {
        return stack.peek();
    }
    
    int getMin() {
        return minStack.peek();
    }
}
```

**Problems**:
- Min stack
- Max stack
- Stack with increment operation

## Classic Problems

### Easy
- Valid parentheses
- Min stack
- Implement queue using stacks
- Remove all adjacent duplicates in string
- Baseball game
- Next greater element I

### Medium
- Daily temperatures
- Evaluate reverse polish notation
- Decode string
- Asteroid collision
- Remove k digits
- Online stock span
- Next greater element II
- Sum of subarray minimums

### Hard
- Largest rectangle in histogram
- Maximal rectangle
- Trapping rain water
- Basic calculator
- Maximum frequency stack

## Applications of Stack

1. **Function Call Stack**: Runtime environment
2. **Undo/Redo Operations**: Text editors
3. **Browser History**: Back button
4. **Expression Evaluation**: Compilers
5. **Syntax Parsing**: Bracket matching
6. **Backtracking**: DFS, maze solving
7. **Memory Management**: Stack memory allocation

## Time & Space Complexity

| Operation | Time | Space |
|-----------|------|-------|
| Push | O(1) | - |
| Pop | O(1) | - |
| Peek | O(1) | - |
| isEmpty | O(1) | - |
| Search | O(n) | - |
| Overall | - | O(n) |

## Stack vs Recursion

Many recursive algorithms can be converted to iterative using explicit stack:

**Recursive**:
```java
void dfs(Node node) {
    if (node == null) return;
    process(node);
    dfs(node.left);
    dfs(node.right);
}
```

**Iterative with Stack**:
```java
void dfs(Node root) {
    if (root == null) return;
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
        Node node = stack.pop();
        process(node);
        
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}
```

## Interview Tips

1. **Recognize LIFO**: When last element needs to be processed first
2. **Auxiliary stack**: Sometimes need two stacks for solution
3. **Monotonic stack**: For next/previous greater/smaller problems
4. **Watch for empty stack**: Always check before pop/peek
5. **Consider edge cases**: Empty stack, single element
6. **Alternative approaches**: Sometimes recursion is cleaner than explicit stack
7. **Java specifics**: Use `Deque<>` instead of `Stack<>` for better performance

## Java Collection Framework

```java
// Recommended: Use Deque instead of Stack
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.pop();
stack.peek();

// Legacy Stack class (synchronized, slower)
Stack<Integer> legacyStack = new Stack<>();
```

## Common Pitfalls

- Not checking if stack is empty before pop/peek
- Using Stack class instead of Deque
- Not maintaining additional information (like min/max) when needed
- Forgetting to handle edge cases (empty input, single character)
- Not recognizing when monotonic stack pattern applies

## Practice Strategy

1. Master basic implementation (array and linked list)
2. Solve balanced parentheses problems
3. Learn monotonic stack pattern (very important!)
4. Practice expression evaluation problems
5. Solve special stack problems (min stack, etc.)
6. Apply stack to tree/graph traversal
7. Convert recursive solutions to iterative using stack
