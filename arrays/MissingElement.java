/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2 */

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
            {
                hm.put(nums[i],hm.get(nums[i])+1);
                if(hm.get(nums[i])>(nums.length/2))
                {
                    return nums[i];
                }
            }
            else
            {
                hm.put(nums[i],1);
            }
        }
        return -1;
    }
}
//Time Complexity - O(n) ,Space Complexity -O(n)
