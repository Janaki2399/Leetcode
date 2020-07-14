/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

Solution:
class Solution {
    public int climbStairs(int n) {
        
int[] arr=new int[n+1];
    arr[0]=1;
   arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            arr[i]=arr[i-2]+arr[i-1];
        }
    return arr[n];
    }
} 
