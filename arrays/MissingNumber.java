/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8*/

Solution:

//Inefficient
class Solution {
    public int missingNumber(int[] nums) {
       int o=nums.length;
        
        int sum2=(o*(o+1))/2;
        int sum1=0;
        for(int i=0;i<nums.length;i++)
        {
            sum1=sum1+nums[i];
        }
        
        return sum2-sum1;
    }
}

// Using Xor Method
class Solution {
    public int missingNumber(int[] nums) {
      int res=0;
    for(int i=0;i<nums.length;i++)
    {
       res= res^i^nums[i];
    }
        return res^nums.length;
    }
}

Follow if :
If array is sorted:

  public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]>mid) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
