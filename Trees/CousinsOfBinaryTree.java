/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false*/

Iterative:
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) 
    {
       Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            Boolean visited1=false;
             Boolean visited2=false;
            int size=q.size();
            while(size-->0)
            {
              root=q.poll();
            if(root.left!=null && root.right!=null )
            {
            if((root.left.val==x || root.left.val==y) &&( root.right.val ==y || root.right.val==x))
            {
                return false;
            }    
            }
            if(root.val==x)
            {
                visited1=true;
            }
          if(root.val==y)
             {
                visited2=true;
              }
                
            if(root.left!=null)
            {
                q.add(root.left);
            }
            if(root.right !=null)
            {
                q.add(root.right);
            }
            }
             if(visited1==true && visited2==true)
        {
            return true;
        }
        }
       
        
        
    return false;
    }

}

Recursive:

class Solution {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent? true: false;
    }
    //get both the depth and parent for x and y
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }       
        getDepthAndParent(root.left, x, y, depth + 1, root);
        getDepthAndParent(root.right, x, y, depth + 1, root);
    }
}
