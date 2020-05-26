/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1 */

Explanation:
/*If the entire left part is monotonically increasing, which means the pivot point is on the right part
If left <= target < mid ------> drop the right half
Else ------> drop the left half
If the entire right part is monotonically increasing, which means the pivot point is on the left part
If mid < target <= right ------> drop the left half
Else ------> drop the right half*/
Solution:

class Solution {
    public int search(int[] a, int x) {
        int start=0;
        int end=a.length-1;
        
        while(start<=end)
        {
           int mid=(start+(end-start)/2);
             if(a[mid]==x)
            {
                return mid;
            }
           else if(a[mid]>=a[start])
            {
                if(x>=a[start] && x< a[mid])
                {
                end=mid-1;
                }
                else
                {
                      start=mid+1;
                }
            }
            else if(a[mid]<=a[end])
            {
                if(x<=a[end] && x>a[mid] )
                {
                    start=mid+1;
                }
                else
                {
                end=mid-1;
                }
            }
           
        }
        return -1;
    }
}


