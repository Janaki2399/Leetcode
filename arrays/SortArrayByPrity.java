/*Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000
*/

Solution:
Inefficient Solution
class Solution {
    public int[] sortArrayByParity(int[] A) {
    int countEven=0;
    int countOdd=0;
    for(int i=0;i<A.length;i++)
    {
        if(A[i]%2==0)
        {
            countEven++;
            A[i]=-A[i];
        }
        else
        {
            countOdd++;
        }
    }
    int[] arr=new int[countEven+countOdd];
    int j=0;
    int k=countEven;
    for(int i=0;i<arr.length;i++)
    {
        if(A[i]<=0)
        {
            arr[j]=Math.abs(A[i]);
            j++;
        }
        else
        {
            arr[k]=A[i];
            k++;
        }
    }
    return arr;
    }
}
Solution 2:
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int size = A.length;
        int start = 0, end = size - 1;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            if (A[i] % 2 == 1) {
                res[end--] = A[i];
            } else {
                res[start++] = A[i];
            }
        }
        return res;
    }
}

Efficient:
USING 2 POINTERS
class Solution {
    public int[] sortArrayByParity(int[] a) {
    int i=0;
    int j=0;
    while(i<a.length & j<a.length)
    {
        if(a[j]%2==0)
        {
            int temp=a[j];
            a[j]=a[i];
            a[i]=temp;
            i++;
            j++;
        }
        else
        {
            j++;
        }
    }
