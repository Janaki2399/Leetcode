/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

Solutions:

class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
          List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
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
            if(i>start && nums[i]==nums[i-1])
            {
                continue;
            }
            templist.add(nums[i]);
            cm(list,templist,nums,i+1,target-nums[i]);
            templist.remove(templist.size()-1);
        }
        }
    }
    
}
