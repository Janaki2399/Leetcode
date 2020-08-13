/*Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5*/

Solution:
class Solution {
    public int[] replaceElements(int[] arr) {
    int[] new_array=new int[arr.length];
    new_array[arr.length-1]=-1;
    int j=arr.length-2;
    for(int i=arr.length-2;i>=0;i--)
    {
        new_array[j]=Math.max(arr[i+1],new_array[i+1]);
        j--;
    }
    return new_array;
    }
}

Efficient:

class Solution {
    public int[] replaceElements(int[] arr) {
    int a=-1;
    int temp=0;
    for(int i=arr.length-2;i>=0;i--)
    {
        temp=arr[i];
        arr[i]=Math.max(arr[i+1],a);
        a=temp;
    }
    arr[arr.length-1]=-1;
    return arr;
    }
}

Simplified:
class Solution {
    public int[] replaceElements(int[] arr) {
    int max=-1;
    int temp=0;
    for(int i=arr.length-1;i>=0;i--)
    {
        temp=arr[i];
        arr[i]=max;
        max=Math.max(max,temp);
        
    }
    
    return arr;
    }
}
