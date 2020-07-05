/*In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.*/


Solution:

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();  
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1)
            
        {
            return -1;
        }
       if(grid.length==1 && grid[0].length ==1)
       {
           return 1;
       }
        q.add(new int[]{0,0});
        int count=0;
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{-1,1},{1,1},{-1,-1},{1,-1}};
        
        while(!q.isEmpty())
        {  count++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] crd=q.poll();
                for(int[] d:dir)
                {
                    int x=crd[0]+d[0];
                    int y=crd[1]+d[1];
                    if(x==grid.length-1 && y==grid[0].length-1 )
                    {
                        return count+1;
                    }
                    if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1 || grid[x][y]==1)
                    {
                        continue;
                    }
                        q.add(new int[]{x,y});
                        grid[x][y]=1;    
                }
                
            }
          
        }
        return -1;
        }
}
