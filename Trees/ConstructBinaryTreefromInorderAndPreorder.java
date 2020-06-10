/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7*/

class Solution {
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      
     TreeNode  res= helper(preorder,inorder,0,inorder.length-1);
        index=0;
        return res;
    }
    
    public TreeNode helper(int[] preorder,int[] inorder,int start,int end )
    {
        if(start>end)
        {
            return null;
        }
        int i;
        for( i=start;i<=end;i++)
        {
            if(preorder[index]==inorder[i])
            {
    
                break;
            }
        }
        TreeNode root=new TreeNode(preorder[index]);
        index++;
        root.left=helper(preorder,inorder,start,i-1);
        root.right=helper(preorder,inorder,i+1,end);
        
        return root;
    }
    
}
