/*Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

Solution:
Iterative:
class Solution {
    public TreeNode invertTree(TreeNode root) {
    if(root==null)
    {
        return root;
    }
    Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr1=q.poll();
            TreeNode temp=curr1.left;
            curr1.left=curr1.right;
            curr1.right=temp;
           
            if(curr1.left!=null)
            {
                q.add(curr1.left);
                
            }
            if(curr1.right!=null)
            {
                q.add(curr1.right);
            }
        }
        return root;
    }
}
Recursive:
class Solution {
    public TreeNode invertTree(TreeNode root) {
    if(root==null)
    {
        return null;
    }
   TreeNode left=invertTree(root.left);
  TreeNode right=  invertTree(root.right);
        root.left=right;
        root.right=left;
        
    return root;
    }
}

