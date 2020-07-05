/*In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.*/


Solution:

class Solution {
    public int orangesRotting(int[][] grid) {
         if(grid == null || grid.length == 0) return 0;
        Queue<int[]> q=new LinkedList<>();
        int count_fresh=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
               else if(grid[i][j]==1)
                {
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh==0)
        {
            return 0;
        }
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        int count=0;
        while(!q.isEmpty())
        {
            ++count;
         int size=q.size();//be careful here
            for(int i=0;i<size;i++)
            {
                int[] corrd=q.poll();
                
                for(int d[]:dir)
                {
                    int x=corrd[0]+d[0];
                    int y=corrd[1]+d[1];
                    
                  if(x<0 || y<0 ||x>= grid.length || y>= grid[0].length || grid[x][y]==0 || grid[x][y]==2)
                  {
                      continue;
                  }
                    grid[x][y]=2;
                    q.add(new int[]{x,y});
                    count_fresh--;
                }
            }
            
        }
        
        return count_fresh==0 ? count-1 : -1;
    }
}
