/*Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

 

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4]
Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 1 
row 1 -> 4 
row 2 -> 1 
row 3 -> 1 
Rows ordered from the weakest to the strongest are [0,2,3,1]*/

Solution:
TC:The time complexity should be O(M(logN + logk) + k) = O(M log(Nk) + k) = O(M log(Nk)).

NOTE: k <= M, logN comes from priority queue with max size k, and logN comes from binary search for each row with size N.
Space complexity is just O(k) to store the result and priority queue.

NOTE: function numOnes has only O(1) space for binary search.

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
    HashMap<Integer,Integer> hm=new HashMap<>();
   for(int i=0;i<mat.length;i++)
   {
      int left=0;
       int right=mat[0].length;
       while(left<right)
       {
           int  mid=(left+right)/2;
            if(mat[i][mid]==0)
            {
            right=mid;
            }
           else if(mat[i][mid]==1)
           {
               left=mid+1;
           }
           
       }

       hm.put(i,left);
   }
    PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =new PriorityQueue<>((a,b) ->a.getValue().equals(b.getValue()) ? b.getKey() - (a.getKey()): b.getValue()-a.getValue());
        
for(Map.Entry<Integer,Integer> entry:hm.entrySet())
{
    maxHeap.add(entry);
    if(maxHeap.size()>k)
    {
        maxHeap.poll();
    }
        
}
int[] result=new int[k];
    for(int i=k-1;i>=0;i--)
    {
        Map.Entry<Integer,Integer> entry=maxHeap.poll();
        result[i]=entry.getKey();
    }
        
    return result;
    }
}


Another:
public int[] kWeakestRows(int[][] mat, int k) {
    int rows = mat.length;
    int cols = mat[0].length;

    int[] score = new int[rows];
    int j;
    for (int i = 0; i < rows; i++) {
        j = 0;
        for (; j < cols; j++) {
            if (mat[i][j] == 0) {
                break;
            }
        }
		/*
		 * we can create a score to match the sort condition from description
		 * score = soldiersCount * rows + currentRowIndex
		 * so we can get soldiersCount by score / rows, and get rowIndex by score % rows
		 */
        score[i] = j * rows + i;
    }

    Arrays.sort(score);
    for (int i = 0; i < score.length; i++) {
		// get rowIndex
        score[i] = score[i] % rows;
    }

    return Arrays.copyOfRange(score, 0, k);
}
