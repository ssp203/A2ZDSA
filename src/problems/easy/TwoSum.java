package problems.easy;

/**
 * Problem: Two Sum
 * Source: LeetCode #1
 * Difficulty: Easy
 * 
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 * 
 * Approach 1: Brute Force
 * - Use nested loops to check all pairs
 * - Time Complexity: O(n²)
 * - Space Complexity: O(1)
 * 
 * Approach 2: Hash Map (Optimal)
 * - Store elements in HashMap with their indices
 * - For each element, check if (target - element) exists
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    
    /**
     * Optimal solution using HashMap
     * Time: O(n), Space: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        // Edge case
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        
        // HashMap to store value -> index mapping
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Store current number with its index
            map.put(nums[i], i);
        }
        
        // No solution found
        return new int[]{-1, -1};
    }
    
    /**
     * Brute force solution (for learning purposes)
     * Time: O(n²), Space: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: Normal case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test 1: " + Arrays.toString(twoSum(nums1, target1)));
        // Expected: [0, 1]
        
        // Test case 2: Multiple valid pairs (returns first found)
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Test 2: " + Arrays.toString(twoSum(nums2, target2)));
        // Expected: [1, 2]
        
        // Test case 3: Same number used twice
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Test 3: " + Arrays.toString(twoSum(nums3, target3)));
        // Expected: [0, 1]
        
        // Test case 4: Negative numbers
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        System.out.println("Test 4: " + Arrays.toString(twoSum(nums4, target4)));
        // Expected: [2, 4] (indices where -3 and -5 are located)
        
        // Test case 5: No solution
        int[] nums5 = {1, 2, 3};
        int target5 = 10;
        System.out.println("Test 5: " + Arrays.toString(twoSum(nums5, target5)));
        // Expected: [-1, -1]
        
        System.out.println("\n--- Comparing with Brute Force ---");
        System.out.println("Brute Force Test 1: " + 
                          Arrays.toString(twoSumBruteForce(nums1, target1)));
    }
}
