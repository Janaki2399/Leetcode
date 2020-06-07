/*Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7*/

Solution: Creating a new tree using recursion
Recursion:
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1==null &&root2==null)
        {
            return null;
        }
        if(root1==null)
        {
            return root2;
        }
        if(root2==null)
        {
            return root1;
        }
        
        TreeNode n=new TreeNode(root1.val+root2.val);
        
        n.left=mergeTrees(root1.left,root2.left);
        n.right=mergeTrees(root1.right,root2.right);
        
        return n;
    }
}

Iterative :

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
    
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root1);
        q.add(root2);
        if(root1==null)
        {
            return root2;
        }
        while(!q.isEmpty())
        {
            TreeNode curr1=q.poll();
            TreeNode curr2=q.poll();
            
          
            if(curr1!=null && curr2!=null)
            {
            curr1.val+=curr2.val;
                   
        if(curr1.left==null)
            {
            curr1.left=curr2.left;    
            }
            else
            {
                q.add(curr1.left);
            q.add(curr2.left);
                
            }
         if(curr1.right==null)
         {
             curr1.right=curr2.right;
         }
          else
          {
            q.add(curr1.right);
            q.add(curr2.right);
          }
            }
        }
     return root1;   
    }
}

