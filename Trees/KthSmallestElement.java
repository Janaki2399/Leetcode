/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3*/

Iterative solution:

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st =new Stack<TreeNode>();
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
                node=st.pop();
                k--;
                if(k==0)
                {
                    return node.val;
                }
                node=node.right;
            }
        }
      
    }
}

Recursive solution:

int count = 0;
int result = Integer.MIN_VALUE;

public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return result;
}

public void traverse(TreeNode root, int k) {
    if(root == null) return;
    traverse(root.left, k);
    count ++;
    if(count == k) result = root.val;
    traverse(root.right, k);       
}
