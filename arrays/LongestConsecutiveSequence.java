/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.*/

Solution 1:
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        Arrays.sort(nums);
        int count=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]-1==nums[i-1])
            {
                count++;
            }
            else if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            else
            {
                count=1;
            }
            if(count>max)
            {
                max=count;
            }
        }
        return max;
    }
}

Solution 2: efficient
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
       HashSet<Integer> hs=new HashSet<>();
        
        for(int n:nums)
        {
            hs.add(n);
        }
        int max=Integer.MIN_VALUE;
        int next=0;
        int count=0;
        for(int n:hs)
        {
            if(!hs.contains(n-1))
            {
                next=n+1;
                count=1;
                while(hs.contains(next))
                {
                    next++;
                    count++;
                }
                max=Math.max(max,count);
            }
             
        }
        return max;
    }
}
