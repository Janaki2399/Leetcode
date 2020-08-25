/*Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

 

Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22*/

Solution:
class Solution {
  
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
  int sum= CalculatingSum(root,sb);
        
    return sum;
    }
    public int CalculatingSum(TreeNode root,StringBuilder sb)
    {
         int sum=0;
        if(root!=null)
    {
        int sl=sb.length();
        sb.append(root.val);
    
       
        if(root.left==null && root.right==null)
        {
            int val=Integer.parseInt(sb.toString(),2);
     //    sb.deleteCharAt(sb.length()-1);
            return val;
            
        }
	    sum+=  CalculatingSum(root.left,sb);
	     sum+=   CalculatingSum(root.right,sb);
        sb.setLength(sl);
        
        }
        return sum;
    }
}
 
