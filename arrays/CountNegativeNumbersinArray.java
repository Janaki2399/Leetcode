/*Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 */

Solution 1:
Binary search:

class Solution {
    public int countNegatives(int[][] grid) {
    int count=0;

for(int i=0;i<grid.length;i++)
{
    int start=0;
    int end=grid[0].length-1;
    if(grid[i][start]<0)
    {
        count+=end+1;
        continue;
    }
    else if(grid[i][end]>0)
    {
        continue;
    }
    while(start<=end)
    {
        int mid=start+(end-start)/2;
        
        if(grid[i][mid]<0)
        {
          end=mid-1;
        }
        else
        {
            start=mid+1;
        }
    
    }
  count+=grid[0].length-start;  
}
    return count;
    }
}
Solution 2:
TC-O(n+m)

 public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c; // there are n - c negative numbers in current row.
            }else {
                ++c;
            }
        }
        return cnt;
    }

++++++
++++--
++++--
+++---
+-----
+-----
