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
