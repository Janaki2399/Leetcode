/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/

Solution 1:
class Solution {
    public void moveZeroes(int[] nums) {
        
        int i=0;
        int j=i+1;
        while(i<nums.length && j<nums.length)
        {
            if(nums[j]==0)
            {
                j++;
            
            }
            else if(nums[i]== 0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                if(j<nums.length-1)
                {
                    j++;
                }
            }
          else  if(nums[i]!=0)
            {
              if(nums[i+1]==0)
              {
                  i++;
              }
              else
              {
                i++;
                  j++;
              }
                
              
            }
        }
    }
}

Solution 2:
class Solution {
    public void moveZeroes(int[] nums) {
        
   int i=0;
    
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                  i++;
            }
          
        }
    }
}


//comments -start i and j with the same index
