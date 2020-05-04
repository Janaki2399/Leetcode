/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5*/



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k=0;
        int i=0,j=0;
        double median=0;
        int l=nums1.length+nums2.length;
        int[] arr=new int[l];
        
        while(i<nums1.length || j<nums2.length)
        {
        if(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                arr[k]=nums1[i];
                k++;
                i++;
            }
          else if(nums1[i]>nums2[j])
            {
                arr[k]=nums2[j];
                k++;
                j++;
            }
          else 
            {
                arr[k]=nums1[i];
                k++;
                 i++;
                arr[k]=nums2[j];
                k++;  
                j++;
            }
        }
      	 else if(i<nums1.length)
      	 {
          
                arr[k]=nums1[i];
                k++;
            i++; 
       }
   	else if(j<nums2.length)
  	{
        arr[k]=nums2[j];
                k++;
              j++;
    	}
        }
         
     //Finding the median 
        if(arr.length % 2 != 0)
        {
            int num =arr.length/2;
            median=arr[num];
        }
        else if(arr.length % 2==0)
        {
          
           int num=arr.length/2;
            median=(arr[num]+arr[num-1])/2.0;
        }
        return median;
    }
}
