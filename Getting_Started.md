# Getting Started with DSA in Java

## Setting Up Your Environment

### 1. Install Java Development Kit (JDK)
- Download and install JDK 11 or later from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK
- Verify installation: `java -version` and `javac -version`

### 2. Choose an IDE
- **IntelliJ IDEA** (Recommended) - Community Edition is free
- **Eclipse** - Free and open-source
- **VS Code** - With Java Extension Pack

### 3. Create Your First DSA Project

```bash
# Create project directory
mkdir DSA-Practice
cd DSA-Practice

# Create source directory
mkdir -p src/com/dsa
```

## Project Structure

```
A2ZDSA/
├── src/
│   ├── basics/           # Basic Java programs and concepts
│   ├── datastructures/   # Implementation of data structures
│   │   ├── arrays/
│   │   ├── linkedlist/
│   │   ├── stack/
│   │   ├── queue/
│   │   ├── tree/
│   │   ├── graph/
│   │   └── heap/
│   ├── algorithms/       # Algorithm implementations
│   │   ├── sorting/
│   │   ├── searching/
│   │   ├── recursion/
│   │   ├── backtracking/
│   │   ├── dp/
│   │   └── greedy/
│   └── problems/         # Practice problem solutions
│       ├── easy/
│       ├── medium/
│       └── hard/
├── DSA_Learning_Plan_Java.md
└── README.md
```

## Your First Data Structure: Array

Create a file `src/basics/ArrayExample.java`:

```java
package basics;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        // Declaration and initialization
        int[] numbers = {5, 2, 8, 1, 9};
        
        // Print original array
        System.out.println("Original: " + Arrays.toString(numbers));
        
        // Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));
        
        // Binary search (array must be sorted)
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);
        
        // Find max element
        int max = findMax(numbers);
        System.out.println("Max element: " + max);
    }
    
    // Custom method to find maximum
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
```

## Compile and Run

```bash
# Compile
javac src/basics/ArrayExample.java

# Run
java -cp src basics.ArrayExample
```

## Important Java Collections for DSA

### ArrayList (Dynamic Array)
```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.get(0);        // Access element
list.size();        // Get size
```

### LinkedList
```java
import java.util.LinkedList;

LinkedList<String> list = new LinkedList<>();
list.add("First");
list.addFirst("New First");
list.addLast("Last");
```

### HashMap (Hash Table)
```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 1);
map.put("banana", 2);
map.get("apple");           // Returns 1
map.containsKey("apple");   // Returns true
```

### TreeMap (Sorted Map)
```java
import java.util.TreeMap;

TreeMap<Integer, String> map = new TreeMap<>();
map.put(3, "three");
map.put(1, "one");
// Keys are automatically sorted
```

### PriorityQueue (Heap)
```java
import java.util.PriorityQueue;

PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.add(5);
minHeap.add(2);
minHeap.poll();  // Returns 2 (minimum element)
```

### Stack
```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.pop();     // Returns 2
stack.peek();    // Returns 1
```

### Queue
```java
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.offer(2);
queue.poll();    // Returns 1
```

## Basic Problem-Solving Template

```java
package problems;

public class ProblemTemplate {
    /**
     * Problem: [Description]
     * 
     * Approach:
     * 1. [Step 1]
     * 2. [Step 2]
     * 
     * Time Complexity: O(?)
     * Space Complexity: O(?)
     */
    public static int solve(int[] arr) {
        // Edge cases
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        // Your solution logic here
        
        return 0;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] test1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + solve(test1));
        
        int[] test2 = {};
        System.out.println("Test 2: " + solve(test2));
        
        int[] test3 = {-1, -2, -3};
        System.out.println("Test 3: " + solve(test3));
    }
}
```

## Tips for Beginners

1. **Start Simple:** Begin with easy problems on arrays and strings
2. **Understand First:** Don't just memorize solutions; understand the logic
3. **Code Daily:** Practice at least 1-2 problems every day
4. **Debug Practice:** Learn to use debugger in your IDE
5. **Write Tests:** Always test your code with multiple test cases
6. **Comment Your Code:** Explain complex logic with comments
7. **Analyze Complexity:** Always think about time and space complexity

## Common Java Pitfalls to Avoid

1. **Integer Overflow:**
   ```java
   int result = 1000000 * 1000000;  // Overflow!
   long result = 1000000L * 1000000L;  // Correct
   ```

2. **Array Index Out of Bounds:**
   ```java
   // Always check array bounds
   if (i >= 0 && i < arr.length) {
       // Safe to access arr[i]
   }
   ```

3. **Null Pointer Exception:**
   ```java
   // Check for null before using
   if (obj != null) {
       obj.method();
   }
   ```

4. **String Comparison:**
   ```java
   String s1 = "hello";
   String s2 = "hello";
   s1 == s2;        // DON'T use this for strings
   s1.equals(s2);   // Use this instead
   ```

## Resources for Practice

1. **LeetCode** - Start with "Top Interview Questions" list
2. **HackerRank** - Complete Java track first
3. **GeeksforGeeks** - Good for theory and basic problems
4. **Codeforces** - For competitive programming

## Next Steps

1. Follow the [complete learning plan](DSA_Learning_Plan_Java.md)
2. Start with Phase 1: Fundamentals
3. Implement data structures from scratch
4. Solve problems daily
5. Join coding communities for support

Happy Coding! 🚀
