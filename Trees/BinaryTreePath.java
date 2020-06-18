/*Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3*/

Solution:

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ar=new ArrayList<String>();
    
        path(ar,root,"");
        return ar;
    }
    
    public void path(List ar,TreeNode root,String sb)
    {
        
       sb=sb+root.val;
        
        if(root.left==null && root.right==null)
           {
                  ar.add(sb.toString());
                return;
           }
          if(root.left!=null)
          {
        path(ar,root.left,sb+"->");
          }
        if(root.right!=null)
        {
         path(ar,root.right,sb+"->");
        }
    }
}


Solution 2: using string Builder:

class Solution
{
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    helper(res, new StringBuilder(), root);
    return res;
}

private void helper(List<String> res, StringBuilder sb, TreeNode root) {
    if(root == null) {
        return;
    }
    int len = sb.length();
    System.out.println(len);
    if(root.left == null && root.right == null) {
        sb.append(root.val);
        res.add(sb.toString());
        sb.setLength(len);
        return;
    }
    sb.append(root.val).append("->");
    helper(res, sb, root.left);
    helper(res, sb, root.right);
    sb.setLength(len);
}
}
