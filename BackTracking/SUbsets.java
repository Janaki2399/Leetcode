/*Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

Solution:

class Solution {
   public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
     ArrayList<Integer> tempList=new ArrayList<>();
   list.add(new ArrayList<>(tempList));
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    if(start==nums.length)
    {
        return;
    }
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        list.add(new ArrayList<>(tempList));  
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
       
    }
}
} 	
