Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


Solution :
Recursive :
Method 1:

class Solution {
    
    public boolean hasPathSum(TreeNode root, int sum) {
         
        if(root==null)
        {
            return false;
        }
        
        if(root.left==null && root.right==null)
        {
            if(sum==root.val)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    if(hasPathSum(root.left,sum-root.val))
    {
        return true;
    }
    if(hasPathSum(root.right,sum-root.val))
    {
        return true;
    }
        return false;
    }
 }

Method 2:
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

Method 3:
Iterative:
public boolean hasPathSum(TreeNode root, int sum) {
  
    if (root == null) {return false;}
    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> sub = new Stack<>();
    path.push(root);
    sub.push(root.val);
    while (!path.isEmpty()) {
        TreeNode temp = path.pop();
        int tempVal = sub.pop();
        if (temp.left == null && temp.right == null) {if (tempVal == sum) return true;}
        else {
            if (temp.left != null) {
                path.push(temp.left);
                sub.push(temp.left.val + tempVal);
            }
            if (temp.right != null) {
                path.push(temp.right);
                sub.push(temp.right.val + tempVal);
            }
        }
    }
    return false;
}
