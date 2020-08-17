/*Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.*/

Solution:

class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int i=0,j=0;
      while(i<arr.length && j<arr.length)
      {
          if(arr[i]%2==0 && i%2!=0)//even number ,odd position
          {
              while((arr[j]%2==0 && j%2==0) ||(arr[j]%2!=0 && j%2!=0) || (j%2!=0 && arr[j]%2==0))
              {
                  j++;
              }
          if(j==arr.length)
          {
              break;
          }
              swap(arr,i,j);
              i++;
              j=i+1;
          }
      else  if(arr[i]%2!=0 && i%2==0)//odd number ,even position
          {
          System.out.println(arr[i]);
              while((arr[j]%2!=0 && j%2!=0)||(arr[j]%2==0 && j%2==0)|| (j%2==0 && arr[j]%2!=0))
              {
                  j++;
         if(j==arr.length)
          {
              break;
          }
              }
         if(j==arr.length)
          {
              break;
          }
              swap(arr,i,j);
           i++;
          j=i+1;
          
          }
          else
          {
              i++;
              j++;
          }
          
      }
    return arr;  
    }
    public void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}

Efficient one:

class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int i=0,j=0;
      while(i<arr.length && j<arr.length)
      {
          if(arr[i]%2==0 && i%2!=0)//even number ,odd position
          {
              while((arr[j]%2==0 && j%2==0) ||(arr[j]%2!=0 && j%2!=0) || (j%2!=0 && arr[j]%2==0))
              {
                  j++;
              }
          if(j==arr.length)
          {
              break;
          }
              swap(arr,i,j);
              i++;
              j=i+1;
          }
      else  if(arr[i]%2!=0 && i%2==0)//odd number ,even position
          {
          System.out.println(arr[i]);
              while((arr[j]%2!=0 && j%2!=0)||(arr[j]%2==0 && j%2==0)|| (j%2==0 && arr[j]%2!=0))
              {
                  j++;
         if(j==arr.length)
          {
              break;
          }
              }
         if(j==arr.length)
          {
              break;
          }
              swap(arr,i,j);
           i++;
          j=i+1;
          
          }
          else
          {
              i++;
              j++;
          }
          
      }
    return arr;  
    }
    public void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}
