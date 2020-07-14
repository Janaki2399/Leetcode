/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

Solution:
class Solution {
    public int numSquares(int n) {
        int n1=n/2;
        
        int[] arr=new int[n1+1];
        for(int i=1;i<=n1;i++)
        {
            arr[i]=i*i;
        }
    int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=arr[i];j<=n;j++)
            {
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }
        return dp[n]==Integer.MAX_VALUE-1?1:dp[n];
    }
}

Solution 2:
class Solution {
    public int numSquares(int n) {
      
    int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
