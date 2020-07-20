/*Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.*/
SOlution:
TC: O(n) SC-O(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int num:nums)
        {
            hs.add(num);
        }
        for(int i=1;i<Integer.MAX_VALUE;i++)
        {
            if(!hs.contains(i))
            {
             
                return i;
                
            }
        }
        return -1;
    }
}

Efficient solution:

class Solution {
    public int firstMissingPositive(int[] nums) {

       for(int i=0;i<nums.length;i++)
       {     
           while(nums[i]<=nums.length && nums[i]>0 && nums[i]!=nums[nums[i]-1])
           {
               int temp=nums[nums[i]-1];
               nums[nums[i]-1]=nums[i];
               nums[i]=temp;
           }
       }
      
         for(int i=0;i<nums.length;i++)
         {
             if(nums[i]!=i+1)
             {
                 return i+1;
             }
         }
        return nums.length+1;
    }
}
