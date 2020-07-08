/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]*/

Solution:

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        
        cm(list,new ArrayList<Integer>(),nums,0,target);
        
        return list;
    }
    
    public void cm(List<List<Integer>> list,ArrayList<Integer> templist,int[] nums,int start,int target )
    {
        if(target<0)
        {
            return ;
        }
        else if(target==0)
        {
            list.add(new ArrayList<>(templist));
        }
        else
        {
        for(int i=start;i<nums.length;i++)
        {
            templist.add(nums[i]);
            cm(list,templist,nums,i,target-nums[i]); // only i because the numbers can be repeated
            templist.remove(templist.size()-1);
        }
        }
    }
}
