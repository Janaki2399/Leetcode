/*Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.*/

Solution:
Recursive:
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
       return traversal(s,t);
        
    }
    public boolean isequal(TreeNode s,TreeNode t)
    {
    if(t==null && s==null)
        {
            return true;
        }
        if(t==null || s==null)
        {
            return false;
        }
        return s.val==t.val && isequal(s.left,t.left) &&isequal(s.right,t.right);
    }
    
    public boolean traversal(TreeNode s,TreeNode t)
    {
        return  s!=null && (isequal(s,t)||traversal(s.left,t) ||traversal(s.right,t));
    }
}

Iterative:

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
       
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(s);
        boolean same = false;
        
        while(!stack.isEmpty() && !same){
            
            TreeNode node = stack.pop();
            
            if(node.val == t.val){
               same = isSame(node, t);
            }
            
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            
        }
        return same;
    }
    
    private boolean isSame(TreeNode p, TreeNode q){
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        stack.push(p);
        stack.push(q);
        
        while(!stack.isEmpty()){
            
            TreeNode a = stack.pop();
            TreeNode b = stack.pop();
            
            if(a == null && b == null) continue;
        
            if(a == null || b == null) return false;
            
            if(a.val != b.val){
                return false;
            }
            
            stack.push(a.left);
            stack.push(b.left);
            stack.push(a.right);
            stack.push(b.right);
        }
        
        return true;
    }
}
