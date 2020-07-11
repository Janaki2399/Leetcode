/*Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.*/


Solution:

class Solution {
    public boolean canPartition(int[] nums) {
    int sum=0;
    for(int i=0;i<nums.length;i++)
    {
        sum+=nums[i];
    }
    if(sum%2!=0)
    {
        return false;
    }
        
    return subsetSum(nums,sum/2);
    
    }
    
    public boolean subsetSum(int[] nums,int sum)
    {
      boolean[][] arr=new boolean[nums.length+1][sum+1];   
        int j,i;
        for( i=0;i<arr.length;i++)
        {
            arr[i][0]=true;
        }
        
        for(i=1;i<arr.length;i++)
        {
            for(j=1;j<arr[0].length;j++)
            {
                if(nums[i-1]>j)
                {
                     arr[i][j]=arr[i-1][j];
                }
                else if(nums[i-1]<=j)
                {
                    arr[i][j]= arr[i-1][j-nums[i-1]]|| arr[i-1][j];
                }
            }
        }
        return arr[nums.length][sum];
    }
}
