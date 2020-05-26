/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.*/

Solution:

Iterative:

class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int count=1;
        outer:
        while(!q.isEmpty())
        {
            int size=q.size();
        
                 
            while(size-->0)
            {
                root= q.poll();
                if(root.right==null && root.left==null)
                {
                  return count;
                }
                if(root.right!=null)
                {
                    q.offer(root.right);
                }
                if(root.left!=null)
                {
                    q.offer(root.left);
                }
            }
         count++;   
        }
        return count;
    }
}

Recursive:

class Solution {
    public int minDepth(TreeNode root) {
      if(root==null)
      {
          return 0;
      }
    int lf=minDepth(root.left);
        int rf=minDepth(root.right);
        if(lf==0 || rf==0)
        {
            return lf+rf+1;
        }
        else
        {
            return Math.min(lf,rf)+1;
        }
    }
}
