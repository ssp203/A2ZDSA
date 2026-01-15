package basics;

/**
 * RecursionBasics.java
 * 
 * This file demonstrates fundamental recursion concepts and common recursive problems.
 * 
 * Recursion: A function that calls itself to solve smaller instances of the same problem.
 * 
 * Key Components:
 * 1. Base Case - Condition to stop recursion
 * 2. Recursive Case - Function calls itself with modified parameters
 * 3. Progress - Each call should move toward base case
 * 
 * Topics Covered:
 * - Simple recursive functions
 * - Tail recursion
 * - Multiple recursive calls
 * - Recursion with arrays
 * - Understanding call stack
 * - Time and space complexity analysis
 */

public class RecursionBasics {
    
    /**
     * Example 1: Print numbers from N to 1
     * Time: O(n), Space: O(n) - recursion stack
     */
    public static void printNto1(int n) {
        // Base case: stop when n becomes 0
        if (n == 0) {
            return;
        }
        
        // Print current number
        System.out.print(n + " ");
        
        // Recursive call with n-1
        printNto1(n - 1);
    }
    
    /**
     * Example 2: Print numbers from 1 to N
     * Time: O(n), Space: O(n) - recursion stack
     */
    public static void print1toN(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // Recursive call first
        print1toN(n - 1);
        
        // Print after recursive call (on the way back)
        System.out.print(n + " ");
    }
    
    /**
     * Example 3: Calculate factorial
     * factorial(n) = n * factorial(n-1)
     * factorial(0) = 1 (base case)
     * 
     * Time: O(n), Space: O(n)
     */
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Recursive case
        return n * factorial(n - 1);
    }
    
    /**
     * Example 4: Calculate Fibonacci number
     * fib(n) = fib(n-1) + fib(n-2)
     * fib(0) = 0, fib(1) = 1 (base cases)
     * 
     * Time: O(2^n) - exponential!, Space: O(n)
     * Note: This is inefficient; use dynamic programming for better solution
     */
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Recursive case: two recursive calls
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * Example 5: Sum of natural numbers from 1 to N
     * sum(n) = n + sum(n-1)
     * 
     * Time: O(n), Space: O(n)
     */
    public static int sumOfN(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        
        // Recursive case
        return n + sumOfN(n - 1);
    }
    
    /**
     * Example 6: Calculate power (x^n)
     * power(x, n) = x * power(x, n-1)
     * 
     * Time: O(n), Space: O(n)
     */
    public static int power(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        
        // Recursive case
        return x * power(x, n - 1);
    }
    
    /**
     * Example 7: Optimized power using divide and conquer
     * Uses the fact that: x^n = (x^(n/2))^2 when n is even
     * 
     * Time: O(log n), Space: O(log n)
     */
    public static int powerOptimized(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        
        // Calculate half power
        int halfPower = powerOptimized(x, n / 2);
        
        // If n is even: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            // If n is odd: x^n = x * (x^(n/2))^2
            return x * halfPower * halfPower;
        }
    }
    
    /**
     * Example 8: Sum of array elements using recursion
     * Time: O(n), Space: O(n)
     */
    public static int arraySum(int[] arr, int index) {
        // Base case: reached end of array
        if (index >= arr.length) {
            return 0;
        }
        
        // Recursive case: current element + sum of rest
        return arr[index] + arraySum(arr, index + 1);
    }
    
    /**
     * Example 9: Check if array is sorted
     * Time: O(n), Space: O(n)
     */
    public static boolean isSorted(int[] arr, int index) {
        // Base case: reached second to last element
        if (index >= arr.length - 1) {
            return true;
        }
        
        // Check if current element <= next element
        // AND rest of array is sorted
        return arr[index] <= arr[index + 1] && isSorted(arr, index + 1);
    }
    
    /**
     * Example 10: Reverse a string using recursion
     * Time: O(n), Space: O(n)
     */
    public static String reverseString(String str) {
        // Base case: empty or single character
        if (str.length() <= 1) {
            return str;
        }
        
        // Recursive case: last char + reverse of rest
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }
    
    /**
     * Example 11: Check if string is palindrome
     * Time: O(n), Space: O(n)
     */
    public static boolean isPalindrome(String str, int left, int right) {
        // Base case: crossed or met in middle
        if (left >= right) {
            return true;
        }
        
        // Check if characters match AND rest is palindrome
        return str.charAt(left) == str.charAt(right) && 
               isPalindrome(str, left + 1, right - 1);
    }
    
    /**
     * Example 12: Count occurrences of a digit in a number
     * Time: O(log n), Space: O(log n)
     */
    public static int countDigit(int n, int digit) {
        // Base case: no more digits
        if (n == 0) {
            return 0;
        }
        
        // Check last digit and recurse for remaining digits
        int count = (n % 10 == digit) ? 1 : 0;
        return count + countDigit(n / 10, digit);
    }
    
    /**
     * Example 13: GCD (Greatest Common Divisor) using Euclidean algorithm
     * gcd(a, b) = gcd(b, a % b)
     * 
     * Time: O(log min(a,b)), Space: O(log min(a,b))
     */
    public static int gcd(int a, int b) {
        // Base case: when b becomes 0, a is the GCD
        if (b == 0) {
            return a;
        }
        
        // Recursive case
        return gcd(b, a % b);
    }
    
    /**
     * Demonstrates recursion tree visualization
     */
    public static void demonstrateRecursionTree() {
        System.out.println("=== Understanding Recursion Tree ===");
        System.out.println("For fibonacci(4):");
        System.out.println("                fib(4)");
        System.out.println("              /        \\");
        System.out.println("          fib(3)      fib(2)");
        System.out.println("         /     \\      /     \\");
        System.out.println("     fib(2)  fib(1) fib(1) fib(0)");
        System.out.println("     /    \\");
        System.out.println("  fib(1) fib(0)");
        System.out.println();
        System.out.println("Notice: fib(2) is calculated multiple times!");
        System.out.println("This is why fibonacci has exponential time complexity.");
        System.out.println();
    }
    
    // Test all recursive functions
    public static void main(String[] args) {
        System.out.println("=== Recursion Basics Demo ===\n");
        
        // Print sequences
        System.out.print("Print N to 1 (N=5): ");
        printNto1(5);
        System.out.println();
        
        System.out.print("Print 1 to N (N=5): ");
        print1toN(5);
        System.out.println("\n");
        
        // Mathematical operations
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci of 7: " + fibonacci(7));
        System.out.println("Sum of 1 to 10: " + sumOfN(10));
        System.out.println("2^5 = " + power(2, 5));
        System.out.println("2^10 (optimized) = " + powerOptimized(2, 10));
        System.out.println();
        
        // Array operations
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Sum of array [1,2,3,4,5]: " + arraySum(arr, 0));
        System.out.println("Is [1,2,3,4,5] sorted? " + isSorted(arr, 0));
        
        int[] unsorted = {1, 3, 2, 4, 5};
        System.out.println("Is [1,3,2,4,5] sorted? " + isSorted(unsorted, 0));
        System.out.println();
        
        // String operations
        String str = "hello";
        System.out.println("Reverse of 'hello': " + reverseString(str));
        
        String palindrome = "radar";
        System.out.println("Is 'radar' palindrome? " + 
            isPalindrome(palindrome, 0, palindrome.length() - 1));
        
        String notPalindrome = "hello";
        System.out.println("Is 'hello' palindrome? " + 
            isPalindrome(notPalindrome, 0, notPalindrome.length() - 1));
        System.out.println();
        
        // Other operations
        System.out.println("Count of digit 2 in 222321: " + countDigit(222321, 2));
        System.out.println("GCD of 48 and 18: " + gcd(48, 18));
        System.out.println();
        
        // Recursion tree visualization
        demonstrateRecursionTree();
        
        // Complexity notes
        System.out.println("=== Complexity Notes ===");
        System.out.println("Most simple recursions: Time O(n), Space O(n) for call stack");
        System.out.println("Divide & conquer (like optimized power): Time O(log n)");
        System.out.println("Multiple recursive calls (like fibonacci): Can be O(2^n) - exponential!");
        System.out.println("Always consider: Can this be done iteratively? Can we use memoization?");
    }
}
