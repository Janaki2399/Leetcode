/*Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.*/

Solution:
class Solution {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
       helper(root,false);
        return sum;
    }
    
    public void helper(TreeNode root,Boolean left)
    {
        if(root==null)
        {
            return ;
        }
        
        helper(root.left,true);
        if(root.left==null && root.right==null && left)
        {
            sum+=root.val;
        }
        helper(root.right,false);
    }
}

Method 2:
class Solution {
  
    public int sumOfLeftLeaves(TreeNode root) {
       int sum=helper(root,false);
        return sum;
    }
    
    public int helper(TreeNode root,Boolean left)
    {
        if(root==null)
        {
            return 0;
        }
           
        if(root.left==null && root.right==null && left)
        {
            return root.val;
        }
    return helper(root.left,true)+helper(root.right,false);
    }
}

Method 3: iterative:
class Solution {
  
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
       Queue<TreeNode> st=new LinkedList<>();
    st.offer(root);
        int sum=0;
    while(!st.isEmpty())
    {
        TreeNode d=st.poll();
        if(d.left!=null && d.left.left==null &&d.left.right==null)
        {
            sum+=d.left.val;
        }
        if(d.left!=null)
        {
            st.add(d.left);
        }
        if(d.right!=null)
        {
            st.add(d.right);       
        }
    }
    return sum;
    }

}
