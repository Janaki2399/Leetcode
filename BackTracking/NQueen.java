/*Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/


Solution:
class Position
{
    int row;
    int col;
    public Position(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> big=new ArrayList<>();
        Position[] pos=new Position[n];
        solve(n,0,pos,big);
        
        return big;
    }
    
    public void solve(int n,int row,Position[] pos,List<List<String>> big)
    {
        if(n==row)
        {
            
             ArrayList<String> small=new ArrayList<>();
            StringBuffer sb=new StringBuffer();
            for(Position p:pos)
            {
                for(int i=0;i<n;i++)
                {
                    if(p.col==i)
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                small.add(sb.toString());
                sb=new StringBuffer();
                
            }
            big.add(small);
            return;
        }
        
        for(int col=0;col<n;col++)
        {
            boolean noattack=true;
            for(int j=0;j<row;j++)
            {
                if(pos[j].col==col || pos[j].col+pos[j].row==row+col || pos[j].row-pos[j].col==row-col )
                {
                    noattack=false;
                    break;
                }
                
               
            }
             if(noattack)
                {
                    pos[row]=new Position(row,col);
                    solve(n,row+1,pos,big);
                }
        }
    }
}
