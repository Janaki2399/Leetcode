/*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
*/
Solution 1:

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[cost.length];
        
        for(int i=0;i<n;i++)
        {
            if(i==0 || i==1)
            {
                dp[i]=cost[i];
            }
            else
            {
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
            }
        }
         return Math.min(dp[n-1],dp[n-2]);
    }
   
}

Solution 2 :Efficient
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
       
        int first=cost[0];
        int second=cost[1];
        for(int i=2;i<n;i++)
        {
         
         int dp=cost[i]+Math.min(first,second);
            first=second;
            second=dp;
        }
         return Math.min(first,second);
    }
   
}
