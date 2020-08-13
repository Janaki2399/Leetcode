/*Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.

Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.

 

Example 1:

Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
Explanation: 
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4. 
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2. 
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4. 
For items 3 and 4 you will not receive any discount at all.
Example 2:

Input: prices = [1,2,3,4,5]
Output: [1,2,3,4,5]
Explanation: In this case, for all items, you will not receive any discount at all.
Example 3:

Input: prices = [10,1,1,6]
Output: [9,0,1,6]*/

Solution:

class Solution {
    public int[] finalPrices(int[] prices) {
    Stack<Integer> st=new Stack<Integer>();
    
    for(int i=prices.length-1;i>=0;i--)
    {
        if(st.isEmpty() )
        {        
            st.push(prices[i]);
        }
        else if(prices[i]>st.peek())
        {
            int value=prices[i];
            prices[i]=prices[i]-st.peek();    
            st.push(value);
        }
        else
        {
        while(!st.isEmpty() && st.peek()>prices[i])
        {
            int poppedElement=st.pop();
        }
            int value=prices[i];
      if(!st.isEmpty())
        {        
            prices[i]-=st.peek();
        }
       st.push(value);
        }
    }
    return prices;
    }
}

Elegant solution:
  public int[] finalPrices(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                A[stack.pop()] -= A[i];
            stack.push(i);
        }
        return A;
    }
