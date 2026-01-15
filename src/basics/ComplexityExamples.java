package basics;

/**
 * ComplexityExamples.java
 * 
 * This file demonstrates various time and space complexities through practical examples.
 * Understanding complexity is crucial for:
 * - Analyzing algorithm efficiency
 * - Comparing different solutions
 * - Making optimization decisions
 * - Interview discussions
 * 
 * Big-O Notation represents worst-case complexity as input size (n) grows.
 * 
 * Common Time Complexities (from best to worst):
 * O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(n³) < O(2^n) < O(n!)
 * 
 * Topics Covered:
 * - Time complexity analysis
 * - Space complexity analysis
 * - Best, Average, and Worst cases
 * - Practical examples for each complexity
 */

public class ComplexityExamples {
    
    /**
     * O(1) - Constant Time
     * Operations that take the same time regardless of input size
     * 
     * Examples: Array access, hash table lookup (average), simple arithmetic
     */
    public static void constantTime() {
        System.out.println("=== O(1) - Constant Time ===");
        
        int[] arr = {1, 2, 3, 4, 5};
        
        // These all take constant time, regardless of array size
        int first = arr[0];              // Access by index: O(1)
        int last = arr[arr.length - 1];  // Access by index: O(1)
        int sum = 5 + 10;                // Arithmetic: O(1)
        
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);
        System.out.println("Sum: " + sum);
        System.out.println("Time Complexity: O(1) - Same operations regardless of n\n");
    }
    
    /**
     * O(log n) - Logarithmic Time
     * Operations that divide the problem in half each step
     * 
     * Examples: Binary search, balanced BST operations
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        
        return -1;
    }
    
    public static void logarithmicTime() {
        System.out.println("=== O(log n) - Logarithmic Time ===");
        
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int index = binarySearch(arr, target);
        
        System.out.println("Binary search for " + target + " found at index: " + index);
        System.out.println("Time Complexity: O(log n)");
        System.out.println("Explanation: Each comparison eliminates half the elements");
        System.out.println("For n=1000, approximately 10 comparisons needed (log₂ 1000 ≈ 10)\n");
    }
    
    /**
     * O(n) - Linear Time
     * Operations that scale proportionally with input size
     * 
     * Examples: Linear search, single loop through array
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {  // Loop runs n times
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {  // Loop runs n times
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void linearTime() {
        System.out.println("=== O(n) - Linear Time ===");
        
        int[] arr = {5, 2, 8, 1, 9, 3, 7};
        int target = 9;
        
        int index = linearSearch(arr, target);
        int max = findMax(arr);
        
        System.out.println("Linear search for " + target + " found at index: " + index);
        System.out.println("Maximum element: " + max);
        System.out.println("Time Complexity: O(n)");
        System.out.println("Explanation: Must check each element once in worst case");
        System.out.println("For n=1000, up to 1000 operations needed\n");
    }
    
    /**
     * O(n log n) - Linearithmic Time
     * Operations that divide and conquer with linear merging
     * 
     * Examples: Merge sort, quick sort (average), heap sort
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Recursively sort halves: O(log n) levels
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge sorted halves: O(n) work
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    
    public static void linearithmicTime() {
        System.out.println("=== O(n log n) - Linearithmic Time ===");
        
        int[] arr = {5, 2, 8, 1, 9, 3, 7};
        System.out.println("Before merge sort: " + java.util.Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After merge sort: " + java.util.Arrays.toString(arr));
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Explanation: log n levels of recursion, n work at each level");
        System.out.println("For n=1000, approximately 10,000 operations (1000 * log 1000)\n");
    }
    
    /**
     * O(n²) - Quadratic Time
     * Operations with nested loops over input
     * 
     * Examples: Bubble sort, selection sort, nested iteration
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {           // Outer loop: n times
            for (int j = 0; j < n - i - 1; j++) {   // Inner loop: n times
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        for (int i = 0; i < n; i++) {           // Loop 1: n times
            for (int j = 0; j < n; j++) {       // Loop 2: n times
                for (int k = 0; k < n; k++) {   // Loop 3: n times → O(n³)
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }
    
    public static void quadraticTime() {
        System.out.println("=== O(n²) - Quadratic Time ===");
        
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("Before bubble sort: " + java.util.Arrays.toString(arr));
        
        bubbleSort(arr);
        System.out.println("After bubble sort: " + java.util.Arrays.toString(arr));
        System.out.println("Time Complexity: O(n²)");
        System.out.println("Explanation: Nested loops, each iterating n times");
        System.out.println("For n=1000, up to 1,000,000 operations needed");
        System.out.println("Note: Matrix multiplication is O(n³) with 3 nested loops\n");
    }
    
    /**
     * O(2^n) - Exponential Time
     * Operations where problem doubles with each additional input
     * 
     * Examples: Recursive fibonacci, generating all subsets
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);  // Two recursive calls!
    }
    
    public static void exponentialTime() {
        System.out.println("=== O(2^n) - Exponential Time ===");
        
        System.out.println("Calculating fibonacci numbers recursively:");
        for (int i = 0; i <= 10; i++) {
            System.out.println("fib(" + i + ") = " + fibonacci(i));
        }
        
        System.out.println("Time Complexity: O(2^n)");
        System.out.println("Explanation: Each call makes 2 more calls, forming binary tree");
        System.out.println("For n=20, approximately 1,000,000 operations");
        System.out.println("For n=40, approximately 1,000,000,000,000 operations!");
        System.out.println("This is why we use dynamic programming for fibonacci\n");
    }
    
    /**
     * Space Complexity Examples
     */
    public static void spaceComplexityExamples() {
        System.out.println("=== Space Complexity Examples ===");
        
        // O(1) - Constant Space
        System.out.println("O(1) Space: Using fixed number of variables");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum of 1-100: " + sum);
        
        // O(n) - Linear Space
        System.out.println("\nO(n) Space: Creating array of size n");
        int n = 10;
        int[] arr = new int[n];  // Space proportional to n
        System.out.println("Created array of size: " + arr.length);
        
        // O(n) - Recursion Stack Space
        System.out.println("\nO(n) Recursion Stack Space:");
        System.out.println("Each recursive call adds frame to stack");
        System.out.println("Factorial(5) uses O(5) space for call stack");
        
        System.out.println();
    }
    
    /**
     * Comparison of different approaches
     */
    public static void comparisonExample() {
        System.out.println("=== Comparison: Finding Pairs with Target Sum ===");
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        
        System.out.println("Problem: Find if any two numbers sum to " + target);
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println();
        
        System.out.println("Approach 1: Brute Force - Check all pairs");
        System.out.println("  Time: O(n²), Space: O(1)");
        System.out.println("  2 nested loops to check each pair");
        System.out.println();
        
        System.out.println("Approach 2: Hash Set - Store seen numbers");
        System.out.println("  Time: O(n), Space: O(n)");
        System.out.println("  Single loop, check if (target - current) exists in set");
        System.out.println();
        
        System.out.println("Approach 3: Two Pointers (if sorted)");
        System.out.println("  Time: O(n), Space: O(1)");
        System.out.println("  Start from both ends, move pointers based on sum");
        System.out.println();
        
        System.out.println("Key Insight: Often trade space for time!");
    }
    
    // Main method to run all examples
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   TIME & SPACE COMPLEXITY EXAMPLES");
        System.out.println("========================================\n");
        
        constantTime();
        logarithmicTime();
        linearTime();
        linearithmicTime();
        quadraticTime();
        exponentialTime();
        spaceComplexityExamples();
        comparisonExample();
        
        System.out.println("========================================");
        System.out.println("         COMPLEXITY SUMMARY");
        System.out.println("========================================");
        System.out.println("O(1)      - Constant      - Array access");
        System.out.println("O(log n)  - Logarithmic   - Binary search");
        System.out.println("O(n)      - Linear        - Single loop");
        System.out.println("O(n log n)- Linearithmic  - Merge sort");
        System.out.println("O(n²)     - Quadratic     - Bubble sort");
        System.out.println("O(2^n)    - Exponential   - Recursive fibonacci");
        System.out.println("O(n!)     - Factorial     - Generate permutations");
        System.out.println("========================================");
    }
}
