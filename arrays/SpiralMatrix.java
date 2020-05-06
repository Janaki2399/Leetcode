/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
          List<Integer> list=new ArrayList<Integer>();
         if(matrix.length==0)
        {
            return list ;
        }
        int start=0;
        int width=matrix[0].length-1;
        int height=matrix.length-1;
        int left=0;
      
        int i;
       
        while(start<=height && left<=width)
        {
            for(i=left;i<=width;i++)
            {
                list.add(matrix[start][i]);
            }
            for(i=start+1;i<=height;i++)
            {
                list.add(matrix[i][width]);
            }
            if(start<height && left <width)
            {
              for(i=width-1;i>=left;i--)
            {
                list.add(matrix[height][i]);
            }
              for(i=height-1;i>start;i--)
            {
                list.add(matrix[i][left]);
            }
            }
            width--;
            height--;
            start++;
            left++;
        }
        return list;
    }
}
