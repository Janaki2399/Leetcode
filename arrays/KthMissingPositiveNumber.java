Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Solution 1:
class Solution {
    public int findKthPositive(int[] nums, int k) {
        int prev=0;
        for(int i=0;i<nums.length;i++)
        {
            int diff=nums[i]-prev;
            diff-=1;
            int val=prev;
           
            while(diff>0)
            {
                val++;
                k-=1;
                if(k==0)
                {
                    return val;
                }
                diff--;
            }
            prev=nums[i];
        }
    return nums[nums.length-1]+k;
    }
    
}


SOlution 2:
   public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) >= k) r = mid;  //missed more or equal than k numbers, left side;
            else l = mid + 1;   // missed less than k numbers, must be in the right side;
        }
        return l + k;
    }
