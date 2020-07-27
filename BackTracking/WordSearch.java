/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/


Solution:
class Solution {
    public boolean exist(char[][] board, String word) {
       
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                
              if(helper(board,word,i,j,0))
              {
                  return true;
              }
            }
        }
      return false;
        
    }
    public boolean helper(char[][] board,String word,int i,int j,int index)
    {
        if(index==word.length())
        {
            return true;
        }
        
        if(i<0 || j>board[0].length-1 || j<0 ||i>board.length-1 || board[i][j]=='*'||board[i][j]!=word.charAt(index) )
        {
            return false;
        }
        
   
       board[i][j]='*'; 
        
      boolean result=  helper(board,word,i-1,j,index+1)||
          helper(board,word,i,j-1,index+1)||
          helper(board,word,i,j+1,index+1)||
          helper(board,word,i+1,j,index+1);
     
   board[i][j]=word.charAt(index);
        
        
        return result;
    }
}
