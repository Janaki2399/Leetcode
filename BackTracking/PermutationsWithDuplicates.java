/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

Solution:

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
    List<List<Integer>> list =new ArrayList<>();   
    int val=0;
  permutations(list,val,nums);
    
        return list;
    }
    public void permutations(List<List<Integer>> list,int l,int [] nums)
    {
   
        if(l==(nums.length-1))
        {
            
         ArrayList<Integer> lt = new ArrayList<>();
        for(int num: nums){
            lt.add(num);
        }
            if(!list.contains(lt))
            {
            list.add(lt);
            }
            return;
              }
        
        for(int i=l;i<nums.length;i++)
            {
            int temp=nums[i];
            nums[i]=nums[l];
            nums[l]=temp;
           
                permutations(list,l+1,nums);
              temp=nums[i];
            nums[i]=nums[l];
            nums[l]=temp;
              
            }
    

    }
    
}

Solution 2:
//A element cannot be used until its previous element of the same value is used
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
     List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
    
}
}
