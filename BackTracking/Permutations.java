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


Solution:
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
