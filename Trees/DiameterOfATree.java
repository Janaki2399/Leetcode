/*Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
*/

Solution:

class Solution {
    int sum=0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
           count(root);
        return sum;
    }
    
    public int count(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
     int l=count(root.left);
        
       int r= count(root.right);
        sum=Math.max(sum,l+r);
        return Math.max(l,r)+1;
    }
}
