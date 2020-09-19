/*Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.*/


Solution:
Brute force:
class Solution {
    public boolean isValidSudoku(char[][] board) {
    
    HashSet<Character> hs=new HashSet<>();
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[0].length;j++)
        {
            if(board[i][j]!='.')
            {
                if(hs.contains(board[i][j]))
                {
                   // System.out.println(hs);
                    return false;
                }
                else
                {
                    hs.add(board[i][j]);
                }
            }
            
        }
        hs.clear();
    }
    hs.clear();
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[0].length;j++)
        {
            if(board[j][i]!='.')
            {
                if(hs.contains(board[j][i]))
                {
                    //  System.out.println("second");
                    return false;
                }
                else
                {
                    hs.add(board[j][i]);
                }
            }
            
        }
        hs.clear();
    }
    hs.clear();
for(int row=0;row<9;row+=3)
{
    for(int col=0;col<9;col+=3)
    {
     for(int i=row;i<row+3;i++)
    {
        for(int j=col;j<col+3;j++)
        {
            if(board[j][i]!='.')
            {
                if(hs.contains(board[j][i]))
                {
                   //  System.out.println("third");
                    return false;
                }
                else
                {
                    hs.add(board[j][i]);
                }
            }
         
        }
     }
         hs.clear();
    }
        
     }
    return true;
    }
}


Efficient:
class Solution {
    public boolean isValidSudoku(char[][] board) {
    
    for(int i = 0; i<9; i++) {
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> cols = new HashSet<>();
        HashSet<Character> cube = new HashSet<>();
        for (int j = 0; j < 9;j++) {
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !cols.add(board[j][i]))
                return false;
            int cubeRow = 3*(i/3) + j/3;
            int cubeCol = 3*(i%3) + j%3;
            System.out.println(i+" "+j+" "+cubeRow +" "+cubeCol);
            System.out.println(board[cubeRow][cubeCol]);
            
            if(board[cubeRow][cubeCol]!='.' && !cube.add(board[cubeRow][cubeCol]))
                return false;
        }
        System.out.println("newLine");
    }
    return true;
    }
}
