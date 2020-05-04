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

The median is (2 + 3)/2 = 2.5
*/
//Brute force Approach: Time Complexity -O(n)
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

//Efficient Approach using Binary Search  Time COmplexity -O(log(m+n))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums1.length>nums2.length)
       {
           return findMedianSortedArrays(nums2,nums1);
       }
        int low=0;
        int high=nums1.length;
        int leftX=0,leftY=0,RightX=0,RightY=0;
        while(low<=high)
        {
            int partitionX=(low+high)/2;
            int partitionY=((nums1.length+nums2.length+1)/2)-partitionX;
            
            if(partitionX==0)
            {
                leftX=Integer.MIN_VALUE;
            }
            else
            {
                leftX=nums1[partitionX-1];
            }
              if(partitionX==nums1.length)
            {
                RightX=Integer.MAX_VALUE;
            }
            else
            {
                RightX=nums1[partitionX];
            }
            
              if(partitionY==0)
            {
                leftY=Integer.MIN_VALUE;
            }
            else
            {
                leftY=nums2[partitionY-1];
            }
            if(partitionY==nums2.length)
            {
                RightY=Integer.MAX_VALUE;
            }
            else
            {
                RightY=nums2[partitionY];
            }
            
        if(leftX<=RightY && leftY<=RightX)
        {
            if((nums1.length+nums2.length)%2==0)
            {
                return ((double) Math.max(leftX,leftY)+Math.min(RightX,RightY))/2;
            }
            else
            {
               return (double) Math.max(leftX,leftY);
            }
        }
            else if(leftX>RightY)
            {
                high=partitionX-1;
                
            }
            else
            {
                low=partitionX+1;
            }
        }
        throw new IllegalArgumentException();
    }
}


