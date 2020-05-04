/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
] */

class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> group=new ArrayList<List<Integer>>();
        
        for(int i=0;i<numRows;i++)
        {
            List<Integer> ind=new ArrayList<Integer>();
            
            List<Integer> prev=new ArrayList<Integer>();
            for(int j=0;j<=i;j++)
            {
                if(j == 0 || j==i)
                {
                    ind.add(1);
                }
                else
                {
                    prev=group.get(i-1);
                    int sum=prev.get(j-1)+prev.get(j);
                    ind.add(sum);
                }
                
            }
            group.add(ind);
            
            
        }
        return group;
        
    }
}
