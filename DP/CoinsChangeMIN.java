/*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.*/


Solution 1: USING 2D ARRAY

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] arr=new int[coins.length+1][amount+1];
        for(int i=1;i<arr[0].length;i++)
        {
            arr[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i][0]=0;
        }
     
        for(int i=1;i<arr.length;i++)
        {
            for(int j=1;j<arr[0].length;j++)
            {
                if(coins[i-1]<=j)
                {
                    arr[i][j]=Math.min(arr[i-1][j],arr[i][j-coins[i-1]]+1);
                }
                else
                {
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
    return arr[coins.length][amount]==Integer.MAX_VALUE-1? -1:arr[coins.length][amount];
    }
}


Solution 2 :USING 1D array
class Solution {
    public int coinChange(int[] coins, int amount) {
        
      int[] arr=new int[amount+1];
     Arrays.fill(arr,Integer.MAX_VALUE-1);
    arr[0]=0;
    for(int i=0;i<coins.length;i++)
    {
        for(int j=coins[i];j<=amount;j++)
        {
       
                    arr[j]=Math.min(arr[j],arr[j-coins[i]]+1);
                
              
        }
    }
          return arr[amount] == Integer.MAX_VALUE-1 ? -1 : arr[amount];
    }
}
