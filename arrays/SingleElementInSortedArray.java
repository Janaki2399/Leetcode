/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
*/

Solution:

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
        while(start<=end)
        {
            if(start==end)
            {
                return nums[start];
            }
            int mid=start+(end-start)/2;
            
            if(mid % 2 ==0)
            {
                if(nums[mid] ==nums[mid+1])
                {
                    start=mid+2;
                }
                else
                {
                    end=mid;
                }
            }
            else
            {
                 if(nums[mid] ==nums[mid-1])
                {
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
