/*Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.*/

Solution:
TC-O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left=-1;
        int right=-1;
        int len=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])
            {
                left=i-1;
                break;
            }
        }
        for(int i=nums.length-1;i>=1;i--)
        {
            if(nums[i]<nums[i-1])
            {
                right=i;
                break;
            }
        }
        if(left==-1 ||right==-1)
        {
             return 0;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++)
        {
             max=Math.max(nums[i],max);
             min=Math.min(nums[i],min);
        }
        
        for(int i=0;i<=left;i++)
        {
            if(min<nums[i])
            {
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=right;i--)
        {
            if(max>nums[i])
            {
                right=i;
                break;
            }
        }
        len=right-left+1;
        
        return len;
        
       }
        
}

Simplified:
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left=-1;
        int right=-1;
        int len=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1])
            {
                  min=Math.min(nums[i],min);
            }
                
        }
        for(int i=nums.length-1;i>=1;i--)
        {
            if(nums[i]<nums[i-1])
            {
                   max=Math.max(nums[i-1],max);
            }
        }
      
        
        for(int i=0;i<nums.length;i++)
        {
            if(min<nums[i])
            {
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            if(max>nums[i])
            {
                right=i;
                break;
            } 
        }
        
        return left-right==0?0:right-left+1;
       }
        
}

/*Notes:
	1.check for more test cases
	2.try from both directions of array

