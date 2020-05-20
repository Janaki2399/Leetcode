/*Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.*/

Solution: using recursion:

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        
            int heightleft=maxDepth(root.left);
        int heightright=maxDepth(root.right);
        
        return Math.max(heightleft,heightright)+1;
        
        
    }
}

Iterative :
Method 1: inserting null in queue

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
  
     
    Queue<TreeNode> q=new LinkedList<>();
    int count=0;
   
    q.add(root);
    q.add(null);
    while(!q.isEmpty())
    {
    root = q.poll();
    if(root!=null)
    {
        if(root.left!=null)
        {
            q.add(root.left);
            
            
        }
         if(root.right!=null)
        {
            q.add(root.right);     
        }
        
    }
    else
    {
         count++;
        if(!q.isEmpty())
        {
        q.add(null);
       
        }
    }
    }
        return count;
    }
}

Method 3:

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
  
     
    Queue<TreeNode> q=new LinkedList<>();
    int count=0;
   
    q.add(root);
   
    while(!q.isEmpty())
    {
         int size=q.size();
    while(size-->0)
    {
    root = q.poll();
   
        if(root.left!=null)
        {
            q.add(root.left);
        }
        if(root.right!=null)
        {
            q.add(root.right);
        }
    }
        count++;
    }
        return count;
    }
}
