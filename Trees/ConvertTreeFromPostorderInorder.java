/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7*/

class Solution {
  class pindex
  {
      int index;
      public pindex(int index)
      {
          this.index=index;
      }
  }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      
       pindex ind=new pindex(postorder.length-1);
      
           TreeNode  res= helper(postorder,inorder,0,inorder.length-1,ind);
       return res;
    }
    
    public TreeNode helper(int[] postorder,int[] inorder,int start,int end ,pindex ind)
    {
        if(start>end)
        {
            return null;
        }
      
        int i;
      //  System.out.println(ind.index);
        for( i=start;i<=end;i++)
        {
            if(postorder[ind.index]==inorder[i])
            {
    
                break;
            }
        }
        TreeNode root=new TreeNode(postorder[ind.index]);
        (ind.index)--;
          root.right=helper(postorder,inorder,i+1,end,ind);
        root.left=helper(postorder,inorder,start,i-1,ind);
      
        
        return root;
    }
}


Using HashMap:

class Solution {
    class pindex
  {
      int index;
      public pindex(int index)
      {
          this.index=index;
      }
  }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pindex ind=new pindex(postorder.length-1);
      HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        
        for(int i=0;i<inorder.length;i++)
        {
            hm.put(inorder[i],i);
        }
        TreeNode  res= helper(postorder,inorder,0,inorder.length-1,ind,hm);
       return res;
    }
    
    public TreeNode helper(int[] postorder,int[] inorder,int start,int end,pindex ind,HashMap<Integer,Integer> hm)
    {
        if(start>end)
        {
            return null;
        }  
        TreeNode root=new TreeNode(postorder[ind.index]);
        int v =postorder[ind.index];
           int i= hm.get(v);
        (ind.index)--;
    
          root.right=helper(postorder,inorder,i+1,end,ind,hm);
        root.left=helper(postorder,inorder,start,i-1,ind,hm);
      
        
        return root;
    }
}
