/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3*/

Solutions:

Iterative:
Method 1 :using 2 queue 

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList<>();
          Queue<TreeNode> q2=new LinkedList<>();
        TreeNode curr1=null;
        TreeNode curr2=null;
        if(root==null)
        {
            return true;
        }
        if(root.left==null && root.right==null)
        {
            return true;
        }
        if(root.left==null || root.right==null )
        {
            return false;
        }
        if(root.left!=null)
        {
       curr1=root.left;
              q1.add(curr1);
        }
        if(root.right!=null)
        {
        curr2=root.right;
            q2.add(curr2);
        }
     
        
        while(!q1.isEmpty() && !q2.isEmpty())
        {
            curr1=q1.poll();
            curr2=q2.poll();
            
            if(curr1==null && curr2==null)
            {
                continue;
            }
           
            if(curr1==null || curr2==null)
            {
                return false;
            }
             if(curr1.val != curr2.val)
            {
                return false;
            }
            if(curr1!=null && curr2!=null)
            {
               q1.add(curr1.left);
                q1.add(curr1.right);
                q2.add(curr2.right);
                q2.add(curr2.left);
            }
        
        }
        return true;
    }
}

Method 2 :The above solution is optimized by using 1 Queue

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
         
        q.add(root);
	q.add(root);
        
        while(!q.isEmpty())
        {
      	   TreeNode curr1=q.poll();
           TreeNode curr2=q.poll();
            
            if(curr1==null && curr2==null)
            {
                continue;
            }
           
            if(curr1==null || curr2==null)
            {
                return false;
            }
             if(curr1.val != curr2.val)
            {
                return false;
            }
            
               q.add(curr1.left);
                q.add(curr2.right);
                q.add(curr1.right);
                q.add(curr2.left);
       
        
        }
        return true;
    }
}

Recursive:

class Solution {
    public boolean isSymmetric(TreeNode root) { 
      return Symmetry(root,root);
    }
    public Boolean Symmetry(TreeNode curr1,TreeNode curr2)
    {
        if(curr1==null && curr2==null)
        {
            return true;
        }
        if(curr1==null || curr2==null)
        {
            return false;
        }
        return curr1.val==curr2.val &&  Symmetry(curr1.left,curr2.right) && Symmetry(curr1.right,curr2.left);
    }
}
