/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0*/


Solution 1:
	class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        if(nums.length==1 || nums[end] >nums[start])
        {
            return nums[0];
        }
        
    
        while(start <=end){
          
            
            int mid=(start+end)/2;
          
            if(start<mid  && nums[mid]<nums[mid-1])
            {
              return nums[mid];
            }
           else if(end > mid && nums[mid]>nums[mid+1])
           {
               return nums[mid+1];
           }
            else if(nums[end]>nums[mid])
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return -1;
    }
}

Solution 2:
public class Solution {
public int findMin(int[] num) {
    int low = 0;
    int high = num.length - 1;
    while(low < high){
        int mid = (low + high) / 2;
        if(num[high] < num[mid]){
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return num[high];
}
}
