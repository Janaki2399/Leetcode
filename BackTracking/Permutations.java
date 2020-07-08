/*Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/


Solution 1:
class Solution {
    public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> list =new ArrayList<>();   
  
    permutations(list,0,nums);
    return list;
    }
    public void permutations(List<List<Integer>> list,int l,int [] nums)
    {
   
        if(l==(nums.length-1))
        {
        ArrayList<Integer> lt = new ArrayList<>();
        for(int num: nums)
	{
            lt.add(num);
        }
        list.add(lt);
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
class Solution {
   public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums)
{
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } 
    
    else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
          
         tempList.add(nums[i]);
          
         // System.out.println(i +" "+ tempList);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 
}
