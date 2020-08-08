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
Inefficient approach:
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

Efficient approach : use property of BST :

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        int sum=0;
        while(!st.isEmpty())
        {
            root=st.pop();
            if(root!=null)
            {
            if(root.val>=L && root.val<=R)
            {
                sum+=root.val;
            }
            if(L<root.val)
            {
                
                st.push(root.left);
            }
                
            if( R>root.val)
            {
                st.push(root.right);
            }
            }
        }
        return sum;
    }
}

Recursive approach:

class Solution {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
}
recursive solution 2:
class Solution {
   
    public int rangeSumBST(TreeNode root, int L, int R) {
  
  int sum= helper(root,L,R);
    
    return sum;
    }
    public int helper(TreeNode root,int L,int R)
    {
       if(root==null)
       {
           return 0;
       }
        int sum=0;
        if(root.val>=L && root.val<=R )
        {
          sum+=root.val;
        }
         if(root.val>L)
        {
           sum+= helper(root.left,L,R);
        }
        if(root.val<R)
        {
            sum+=helper(root.right,L,R);
        }
        return sum;
    }
    
}
