/*Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]*/

Method 1:
class Solution {
    
    private int searchRangeInternal(int[] nums, int target, boolean left) {
        int result = -1;
        int front = 0;
        int back = nums.length - 1;
        
        while(front <= back) {
            int mid = (front + back) / 2;
            if (nums[mid] < target) {
                front = mid + 1;
            } else if(nums[mid] > target) {
                back = mid - 1;
            } else {
                if (left) {
                    // keep going towards left
                    back = mid - 1;
                    result = mid;
                } else {
                    // keep moving right
                    front = mid + 1;
                    result = mid;
                }
            }
        }
        
        return result;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int [] result = {-1, -1};
        result[0] = searchRangeInternal(nums, target, true);        
        result[1] = searchRangeInternal(nums, target, false);
        return result;
    }
}

METHOD 2:

public class Solution {
       public  int[] searchRange(int[] nums, int target) {
            int hi = nums.length - 1;
            int low = 0;
            int[] rs = new int[2];
           // base case
            if(nums == null || nums.length == 0)
            	return new int[]{-1, -1 };
            
           //left side
            while(low < hi){
            	int mid = low + (hi - low) /2;
            	if(target > nums[mid]){
            		low = mid + 1;
            	}else{
            		hi = mid;
            	}
            }
            if(target == nums[low]){
        		rs[0] = low;
            }else{
            	rs[0] = -1;
            }
           
            //right side
            hi = nums.length - 1;
            while(low < hi){
            	int mid = (low + (hi - low) /2 ) + 1;
            	
            	if(target < nums[mid]){
            		hi = mid - 1;
            	}else{
            		low = mid;
            	}
            }   
            if(target == nums[hi]){
        		rs[1] = hi;
            }else{
            	rs[1] = -1;
            }
            
            return rs;
        }
    }
