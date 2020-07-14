/*Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

Solution 1:

class Solution {
    public int numIdenticalPairs(int[] nums) {
       int c=0,count=0;
        
       Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(i==nums.length-1 || nums[i]!=nums[i+1] )
            {
                c++;
                count+= c*(c-1)/2;
                c=0;
            }
            else
            {
                c++;
            }
        }
        return count;
    }
}

Solution 2:

 public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    }

Solution 3:

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i])
                count += j - i;
            else i = j;
        }
        return count;
    }
}
