/*Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2*/

 

Solution:

Method 1: to handle only positive numbers use sliding window approach

int subArraySum(int arr[], int n, int sum) 
    { 
        int curr_sum = arr[0], start = 0, i; 
  
        // Pick a starting point 
        for (i = 1; i <= n; i++) { 
            // If curr_sum exceeds the sum, 
            // then remove the starting elements 
            while (curr_sum > sum && start < i - 1) { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
  
            // If curr_sum becomes equal to sum, 
            // then return true 
            if (curr_sum == sum) { 
                int p = i - 1; 
                System.out.println( 
                    "Sum found between indexes " + start 
                    + " and " + p); 
                return 1; 
            } 
  
            // Add this element to curr_sum 
            if (i < n) 
                curr_sum = curr_sum + arr[i]; 
        } 
  
        System.out.println("No subarray found"); 
        return 0; 
    } 



Method2: To handle negative numbers also use Hashing

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
