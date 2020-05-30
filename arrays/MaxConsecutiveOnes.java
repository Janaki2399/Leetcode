/*Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000*/

Solution:
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        
        int i=0;
        int j=0;
        int count=0;
        while(i<nums.length && j<nums.length)
        {
            if(nums[j]==1)
            {
                count=Math.max(count,j-i+1);
                j++;
            }
            else
            {
                
                j++;
                i=j;
               
            }
        }
        return count;
    }
}
