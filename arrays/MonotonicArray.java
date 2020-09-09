/*An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

 

Example 1:

Input: [1,2,2,3]
Output: true
Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
Example 4:

Input: [1,2,4,5]
Output: true
Example 5:

Input: [1,1,1]
Output: true
 

Note:

1 <= A.length <= 50000
-100000 <= A[i] <= 100000*/

Solution:
class Solution {
    public boolean isMonotonic(int[] A) {
   int flag=0;
     for(int i=0;i<A.length-1;i++)
     {
         if(A[i]>A[i+1])
         {
             flag=1;
             break;
         }
     }
    if(flag==0)
    {
        return true;
    }
    if(flag==1)
    {
        for(int i=0;i<A.length-1;i++)
     {
         if(A[i]<A[i+1])
         {
             flag=0;
             break;
         }
     }
    }
    if(flag==0)
    {
        return false;
    }
    return true;
    }
}


Efficient solutions
class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}


class Solution {
    public boolean isMonotonic(int[] A) {
        int inc=1;
        int dec=1;
        for(int i=1; i<A.length; i++){
            if(A[i] - A[i-1] > 0)
                inc++;
            else if(A[i] - A[i-1] < 0)
                dec++;
            else {
                inc++; dec++;
            }
                
        }
        return inc == A.length || dec == A.length;
    }
}
