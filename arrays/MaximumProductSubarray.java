/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,3,-4]
Output: 24
Explanation: [-2,3,-4] has the largest product 24.
*/

class Solution {
    public int maxProduct(int[] nums) {
    
       	int max=nums[0];
        int min=nums[0];
        int product=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=max;
                max=min;
                min=temp;
            }
          max = Math.max(nums[i]*max ,nums[i]);
          min=Math.min(nums[i]*min,nums[i]);
            
          product=Math.max(product,max);
        }
        return product;
    }
}
