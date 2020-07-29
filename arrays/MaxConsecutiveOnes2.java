/*Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.*/

Solution:
class Solution {
    public int longestOnes(int[] A, int K) {
    int count0=0;
    int max=0;
    int i=0;
    for(int j=0;j<A.length;j++)
    {
        if(A[j]==0)
        {
            count0++;
        }
        if( count0 > K)
        {
            if(A[i]==0)
            {
                count0--;
            }
            i++;
        }
     max=Math.max(max,j-i+1);
            
    }
    return max;
    }
}
