/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 

Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.*/

Solution:

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
    int sum=0;
    for(int i=0;i<nums.length;i++)
    {
        sum+=nums[i];
    }
        if(sum<S)
        {
            return 0;
        }
         int s1=(S+sum);
        if(s1 %2==0)
        {
            s1/=2;
        }
        else
        {
            return 0;
        }
    
   
    int count=subsetCount(nums,s1);
    return count;
    }
    
    public int subsetCount(int[] nums,int sum)
    {
        int c0=0;
        int[][] arr=new int[nums.length+1][sum+1];
       //initialization
        arr[0][0]=1;
         for(int i=1;i<arr[0].length;i++)
        {
            arr[0][i]=0;
        }
        for(int i = 1; i < arr.length; i++)
        {
            if(nums[i-1] == 0)
            {
                arr[i][0] = 2*arr[i - 1][0];
            }
            else
            {
                arr[i][0] = arr[i - 1][0];
            }
        }
      //processing
        for(int i=1;i<arr.length;i++)
        {
            for(int j=1;j<arr[0].length;j++)
            {
                if(nums[i-1]<=j)
                {
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-nums[i-1]];
                }
                else
                {
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        
    return arr[nums.length][sum];
    }
}
