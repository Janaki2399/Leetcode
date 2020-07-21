/*Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

 

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

 

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2

 

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
*/

Solution:

class Solution {
    int ans=0;
    public int longestUnivaluePath(TreeNode root) {
        
       helper(root);
       return ans;
    }
    public int helper(TreeNode root)
    {
         if(root==null)
        {
            return 0;
        }
  
       int l= helper(root.left);
       int r=helper(root.right);
      
        if(root.left!=null && root.left.val == root.val)
        {
            l+=1;
        }
        else
        {
            l=0;
        }
        if(root.right!=null && root.right.val == root.val)
        {
            r+=1;
        }
        else
        {
            r=0;
        }
        ans=Math.max(ans,l+r);
        return Math.max(l,r);
    }
}
