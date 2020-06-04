/*Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
*/

Solution:
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        int sum=L+R;
        while(!st.isEmpty())
        {
            root=st.pop();
            if(root.val>L && root.val<R)
            {
                sum+=root.val;
            }
            if(root.left!=null)
            {
                st.push(root.left);
            }
            if(root.right!=null)
            {
                st.push(root.right);
            }
            
        }
        return sum;
    }
}
