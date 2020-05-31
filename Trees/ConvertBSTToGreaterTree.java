/*Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
*/

Solution:
Method 1:
class Solution {
    public TreeNode convertBST(TreeNode root) {
        con(root,0);
        return root;
    }
    public int con(TreeNode root,int sum)
    {
        if(root==null)
        {
            return sum;
        }
        sum=root.val+con(root.right,sum);
        root.val=sum;
        sum=con(root.left,sum);
        
    return sum;
    }
}

Method 2:
class Solution {
    public TreeNode convertBST(TreeNode root) {
        con(root,0);
        return root;
    }
    public int con(TreeNode root,int sum)
    {
        if(root==null)
        {
            return sum;
        }
        sum=root.val+con(root.right,sum);
        root.val=sum;
        sum=con(root.left,sum);
        
    return sum;
    }
}

Method 3 :Iterative
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
}
