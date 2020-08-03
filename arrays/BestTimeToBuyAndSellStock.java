/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.*/

class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length;i++)
        {
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[i]<prices[j])
                {
                    int diff=prices[j]-prices[i];
                    if(diff>max)
                    {
                        max=diff;
                    }
                }
            }
        }
        return max;
    }
}

Solution 2 : Efficient Solution 
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


Solution 3: DP

let profit = []; profit[0] = 0;
for(let i=1;i<prices.length;i++) {
   profit[i] = Math.max(prices[i] - prices[i-1] + profit[i-1], 0);
}

Improvisation:

class Solution {
    public int maxProfit(int[] prices) {
       int currSum=0;
        int maxSum=0;
        
        for(int i=1;i<prices.length;i++)
        {
            currSum=Math.max(0,currSum+prices[i]-prices[i-1]);
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}


