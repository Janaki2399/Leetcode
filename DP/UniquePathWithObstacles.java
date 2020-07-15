/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right*/

Solution:
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
     grid[0][0]^=1;
        for(int i=1;i<grid.length;i++)
        {
            if(grid[i-1][0]==1 && grid[i][0]!=1)
            {
                grid[i][0]=1;
            }
            else
            {
                grid[i][0]=0;
            }
        }
        for(int i=1;i<grid[0].length;i++)
        {
            if(grid[0][i-1]==1 && grid[0][i]!=1)
            {
            grid[0][i]=1;
            }
            else
            {
                grid[0][i]=0;
            }
        }
        for(int i =1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                 
                if(grid[i][j]==1)
                {
                    grid[i][j]=0;
                   
                }
                else
                {
                     grid[i][j]=grid[i-1][j]+grid[i][j-1];
                }
                
               
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}

