/*Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1*/

Solution:
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
        TreeNode root1=null;
      while(!q.isEmpty())
      {
          TreeNode r=q.poll();
          if(r.val>=L && r.val<=R)
          {
              root1=insert(root1,r.val);
          }
          if(r.left!=null)
          {
              q.add(r.left);
          }
          if(r.right!=null)
          {
              q.add(r.right);
          }
      }
    return root1;       
    }
    
    public TreeNode insert(TreeNode root,int val)
    {
       
        if(root==null)
        {
            return new TreeNode(val);
        }
        if(root.val>val)
        {
            root.left = insert(root.left, val);
        }
        else
        {
            root.right=insert(root.right,val);
        }
        return root;
    }
}

Efficient Solution using recursion:

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
     if(root==null)
     {
         return null;
     }
     if(root.val>=L && root.val<=R)
     {
         root.left=trimBST(root.left,L,R);
         root.right=trimBST(root.right,L,R);
     }
    if(root.val<L)
    {
    return trimBST(root.right,L,R);
    }
    if(root.val>R)
    {
    return trimBST(root.left,L,R);
    }
    return root;
    }
}
 
