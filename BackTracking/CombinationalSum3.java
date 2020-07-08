/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
Solution:

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
          List<List<Integer>> list=new ArrayList<>();
        
        cm(list,new ArrayList<Integer>(),n,1,k);
        
        return list;
    }
    
    public void cm(List<List<Integer>> list,ArrayList<Integer> templist,int n,int start,int k )
    {
        if(templist.size()>k)
        {
            return ;
        }
        else if(templist.size()==k && n==0)
        {
            list.add(new ArrayList<>(templist));
        }
        else
        {
        for(int i=start;i<=9;i++)
        {
            templist.add(i);
            cm(list,templist,n-i,i+1,k);
            templist.remove(templist.size()-1);
        }
        }
    }
    
}
