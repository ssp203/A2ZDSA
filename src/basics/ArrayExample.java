package basics;

/**
 * ArrayExample.java
 * 
 * This file demonstrates basic array operations in Java.
 * Arrays are fixed-size data structures that store elements of the same type
 * in contiguous memory locations.
 * 
 * Topics Covered:
 * - Array declaration and initialization
 * - Accessing and modifying elements
 * - Iterating through arrays
 * - Common array operations (search, reverse, find min/max)
 * - Multi-dimensional arrays
 * 
 * Time Complexity Analysis:
 * - Access: O(1)
 * - Search: O(n)
 * - Insertion/Deletion: O(n) due to shifting
 */

import java.util.Arrays;

public class ArrayExample {
    
    /**
     * Demonstrates array declaration and initialization
     */
    public static void arrayBasics() {
        System.out.println("=== Array Basics ===");
        
        // Declaration and initialization - Method 1
        int[] arr1 = new int[5];  // Creates array of size 5 with default values (0)
        
        // Declaration and initialization - Method 2
        int[] arr2 = {1, 2, 3, 4, 5};  // Direct initialization
        
        // Declaration and initialization - Method 3
        int[] arr3 = new int[]{10, 20, 30, 40, 50};
        
        System.out.println("arr1 (default values): " + Arrays.toString(arr1));
        System.out.println("arr2 (direct init): " + Arrays.toString(arr2));
        System.out.println("arr3 (with new): " + Arrays.toString(arr3));
        System.out.println();
    }
    
    /**
     * Demonstrates accessing and modifying array elements
     * Time: O(1) for access and modification
     */
    public static void accessAndModify() {
        System.out.println("=== Access and Modify ===");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Access elements by index
        System.out.println("Element at index 0: " + numbers[0]);
        System.out.println("Element at index 2: " + numbers[2]);
        
        // Modify elements
        numbers[2] = 100;
        System.out.println("After modifying index 2: " + Arrays.toString(numbers));
        
        // Array length
        System.out.println("Array length: " + numbers.length);
        System.out.println();
    }
    
    /**
     * Demonstrates different ways to traverse an array
     * Time: O(n) where n is the array length
     */
    public static void traverseArray() {
        System.out.println("=== Array Traversal ===");
        
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Method 1: For loop with index
        System.out.print("Using for loop: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // Method 2: Enhanced for loop (for-each)
        System.out.print("Using for-each: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Method 3: Using Arrays.toString()
        System.out.println("Using Arrays.toString(): " + Arrays.toString(numbers));
        System.out.println();
    }
    
    /**
     * Search for an element in array (Linear Search)
     * Time: O(n), Space: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Return index if found
            }
        }
        return -1;  // Return -1 if not found
    }
    
    /**
     * Find minimum element in array
     * Time: O(n), Space: O(1)
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    /**
     * Find maximum element in array
     * Time: O(n), Space: O(1)
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Reverse an array in-place
     * Time: O(n), Space: O(1)
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
    /**
     * Calculate sum of all elements
     * Time: O(n), Space: O(1)
     */
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    /**
     * Find average of array elements
     * Time: O(n), Space: O(1)
     */
    public static double arrayAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0.0;
        }
        return (double) arraySum(arr) / arr.length;
    }
    
    /**
     * Demonstrates 2D array (matrix) operations
     */
    public static void twoDimensionalArrays() {
        System.out.println("=== 2D Arrays (Matrix) ===");
        
        // Declaration and initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Access element at row 1, column 2
        System.out.println("Element at [1][2]: " + matrix[1][2]);
        
        // Traverse 2D array
        System.out.println("Matrix traversal:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Test all array operations
    public static void main(String[] args) {
        // Basic operations
        arrayBasics();
        accessAndModify();
        traverseArray();
        
        // Array operations
        int[] numbers = {5, 2, 8, 1, 9, 3, 7};
        
        System.out.println("=== Array Operations ===");
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        // Search
        int target = 8;
        int index = linearSearch(numbers, target);
        System.out.println("Index of " + target + ": " + index);
        
        // Min and Max
        System.out.println("Minimum: " + findMin(numbers));
        System.out.println("Maximum: " + findMax(numbers));
        
        // Sum and Average
        System.out.println("Sum: " + arraySum(numbers));
        System.out.println("Average: " + arrayAverage(numbers));
        
        // Reverse
        reverseArray(numbers);
        System.out.println("Reversed array: " + Arrays.toString(numbers));
        System.out.println();
        
        // 2D arrays
        twoDimensionalArrays();
        
        // Java utility methods
        System.out.println("=== Java Array Utilities ===");
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("Original: " + Arrays.toString(arr));
        
        Arrays.sort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
        
        int searchTarget = 8;
        int result = Arrays.binarySearch(arr, searchTarget);
        System.out.println("Binary search for " + searchTarget + ": index " + result);
        
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Array copy: " + Arrays.toString(copy));
        
        Arrays.fill(arr, 0);
        System.out.println("After fill with 0: " + Arrays.toString(arr));
    }
}
