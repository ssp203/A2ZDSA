# Linked Lists

This directory contains linked list implementations and problem solutions.

## What is a Linked List?

A linked list is a linear data structure where elements (nodes) are stored non-contiguously in memory. Each node contains data and a reference (link) to the next node.

**Advantages over Arrays**:
- Dynamic size
- Efficient insertion/deletion at beginning
- No memory wastage

**Disadvantages**:
- No random access (must traverse from head)
- Extra memory for storing references
- Not cache-friendly

## Types of Linked Lists

### 1. Singly Linked List

```java
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

**Operations**:
- Insert at beginning: O(1)
- Insert at end: O(n) without tail, O(1) with tail
- Insert at position: O(n)
- Delete at beginning: O(1)
- Delete at end: O(n)
- Delete at position: O(n)
- Search: O(n)

### 2. Doubly Linked List

```java
class Node {
    int data;
    Node next;
    Node prev;
    
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
```

**Advantages**:
- Can traverse in both directions
- Delete a given node in O(1) if node reference is given
- Insert before a given node in O(1)

**Disadvantages**:
- Extra memory for prev pointer
- More complex insertion/deletion logic

### 3. Circular Linked List

Last node points back to the first node (or any node), forming a circle.

**Use Cases**:
- Round-robin scheduling
- Circular queue implementation
- Multi-player games (turn rotation)

## Common Operations

### 1. Traversal
```java
void traverse(Node head) {
    Node current = head;
    while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
    }
}
// Time: O(n), Space: O(1)
```

### 2. Insert at Beginning
```java
Node insertAtBeginning(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    return newNode;
}
// Time: O(1), Space: O(1)
```

### 3. Insert at End
```java
Node insertAtEnd(Node head, int data) {
    Node newNode = new Node(data);
    if (head == null) return newNode;
    
    Node current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
    return head;
}
// Time: O(n), Space: O(1)
```

### 4. Delete Node
```java
Node deleteNode(Node head, int key) {
    if (head == null) return null;
    
    // If head needs to be deleted
    if (head.data == key) {
        return head.next;
    }
    
    Node current = head;
    while (current.next != null && current.next.data != key) {
        current = current.next;
    }
    
    if (current.next != null) {
        current.next = current.next.next;
    }
    
    return head;
}
// Time: O(n), Space: O(1)
```

## Classic Problems and Patterns

### Pattern 1: Two Pointers (Fast & Slow)

**Floyd's Cycle Detection (Tortoise and Hare)**:
```java
boolean hasCycle(Node head) {
    if (head == null) return false;
    
    Node slow = head;
    Node fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true;
        }
    }
    
    return false;
}
```

**Problems**:
- Detect cycle in linked list
- Find cycle start node
- Find middle of linked list
- Check if palindrome
- Find nth node from end

### Pattern 2: Reversal

**Reverse entire list**:
```java
Node reverse(Node head) {
    Node prev = null;
    Node current = head;
    
    while (current != null) {
        Node nextTemp = current.next;
        current.next = prev;
        prev = current;
        current = nextTemp;
    }
    
    return prev;
}
```

**Problems**:
- Reverse linked list
- Reverse linked list II (from position m to n)
- Reverse nodes in k-group
- Swap nodes in pairs

### Pattern 3: Merge

**Merge two sorted lists**:
```java
Node mergeTwoLists(Node l1, Node l2) {
    Node dummy = new Node(0);
    Node current = dummy;
    
    while (l1 != null && l2 != null) {
        if (l1.data <= l2.data) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }
    
    current.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

**Problems**:
- Merge two sorted lists
- Merge k sorted lists
- Sort linked list (merge sort)

### Pattern 4: Dummy Node
Use a dummy node to simplify edge cases.

```java
Node dummy = new Node(0);
dummy.next = head;
// Work with dummy.next
return dummy.next;
```

**Problems**:
- Remove nth node from end
- Partition list
- Remove duplicates from sorted list II

## Important Problems

### Easy
- Reverse linked list
- Merge two sorted lists
- Linked list cycle
- Remove duplicates from sorted list
- Intersection of two linked lists
- Palindrome linked list
- Middle of linked list
- Delete node in linked list (given only that node)

### Medium
- Add two numbers (represented as linked lists)
- Remove nth node from end
- Swap nodes in pairs
- Odd even linked list
- Sort list
- Reorder list
- Linked list cycle II
- Copy list with random pointer
- LRU Cache

### Hard
- Reverse nodes in k-group
- Merge k sorted lists

## Time Complexities

| Operation | Singly | Doubly |
|-----------|--------|--------|
| Access | O(n) | O(n) |
| Search | O(n) | O(n) |
| Insert at head | O(1) | O(1) |
| Insert at tail | O(n) or O(1)* | O(1)* |
| Insert at position | O(n) | O(n) |
| Delete at head | O(1) | O(1) |
| Delete at tail | O(n) | O(1)* |
| Delete given node | O(n) | O(1)* |

\* With tail pointer or node reference

## Common Techniques

### 1. Dummy Head
Simplifies edge cases when head might change.

### 2. Two Pointers
- Fast and slow for cycle detection
- Two pointers for finding nth from end

### 3. Recursion
Many linked list problems have elegant recursive solutions.

```java
Node reverseRecursive(Node head) {
    if (head == null || head.next == null) {
        return head;
    }
    
    Node newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;
    
    return newHead;
}
```

### 4. Runner Technique
Use two pointers moving at different speeds.

## Interview Tips

1. **Draw it out**: Visualize with small example (3-5 nodes)
2. **Edge cases**: Empty list, single node, two nodes
3. **Dummy node**: Consider using for cleaner code
4. **Careful with pointers**: Save next before modifying
5. **Two pointers**: Most common technique
6. **Consider space**: Recursion uses O(n) stack space
7. **Time vs Space**: Often can trade stack space for cleaner code

## Common Pitfalls

- Losing reference to head
- Not handling empty list
- Not handling single node list
- Infinite loops in circular list problems
- Not saving next pointer before modification
- Off-by-one errors in counting
- Not checking for null before accessing .next

## Implementation Checklist

When implementing linked list from scratch:
- [ ] Node class with data and next pointer
- [ ] Constructor for list (empty or with values)
- [ ] Insert at beginning
- [ ] Insert at end
- [ ] Insert at position
- [ ] Delete by value
- [ ] Delete by position
- [ ] Search
- [ ] Display/Print
- [ ] Get size
- [ ] Reverse
- [ ] Detect cycle (if applicable)

## Practice Strategy

1. Master basic operations (insert, delete, traverse)
2. Learn reversal (iterative and recursive)
3. Practice two-pointer technique extensively
4. Solve merge problems
5. Tackle cycle detection problems
6. Move to advanced problems (k-group reversal, LRU cache)
7. Always test with edge cases
