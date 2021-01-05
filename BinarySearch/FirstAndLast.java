Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109


Solution
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        
        int val1=searchFirst(nums, target);
        int val2=searchLast(nums,target);
      
       result[0]=val1;
        result[1]=val2;
        return result;
    }
    int searchFirst(int[] nums,int target)
    {
        int res=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                res=mid;
                high=mid-1;
            }
          
        }
        return res;
     
    }
    
  int searchLast(int[] nums,int target)
    {
        int res=-1;
         int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
           if(nums[mid]<target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else 
            {
                res=mid;
                low=mid+1;
            }
        }
    return res;
    }
}
