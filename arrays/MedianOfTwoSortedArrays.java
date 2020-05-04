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
