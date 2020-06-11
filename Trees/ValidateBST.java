/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/

Solutions:

Recursive:  using range 
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        Boolean result=helper(root,null,null);
        return result;
    }
    public Boolean helper(TreeNode root,Integer min,Integer max)
    {
      if(root==null)
      {
          return true;
      }
    if((min !=null && root.val<=min) || (max!=null && root.val>=max))
    {
        return false;
    }
    
return  helper(root.left,min,root.val) && 
       helper(root.right,root.val,max);
      
    }
}

Solution 2: Iterative -using the inorder property that the newly visited element will be larger than the previous element.

class Solution {
    public boolean isValidBST(TreeNode root) {
       if(root==null)
       {
           return true;
           
       }
        Stack<TreeNode> st=new Stack<>();
        TreeNode prev=null;
        TreeNode node=root;
        while(true)
        {
            if(node !=null)
            {
                st.push(node);
                node=node.left;
            }
            else
            {
                if(st.empty())
                {
                    break;
                }
               node= st.pop();
                if(prev!=null && node.val<=prev.val)
                {
                    return false;
                }
                prev=node;
                node=node.right;
            }
        }
      return true;
    }
}
