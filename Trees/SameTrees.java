/*Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false */

Recursive Solution:

	class Solution {
    public boolean isSameTree(TreeNode p, TreeNode p) {
 	if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        
        return p.data == p.data && 
                sameTree(p.left, p.left) &&
                sameTree(p.right, p.right);
        
    }
}

Iterative Solutiion:

method 1: using 2 stacks

class Solution
{
  	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.empty() && !stackQ.empty()) {
            TreeNode np = stackP.pop();
            TreeNode nq = stackQ.pop();
            if (np.val != nq.val) return false;

            if (np.left != null && nq.left != null) {
                stackP.push(np.left);
                stackQ.push(nq.left);
            } 

	    else if (np.left != null || nq.left != null) {
                return false;
            }

            if (np.right != null && nq.right != null) {
                stackP.push(np.right);
                stackQ.push(nq.right);
            } 

	    else if (np.right != null || nq.right != null) {
                return false;
            }
        }
        return true;
    }
}

Method 2: using 2 queue

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {

  Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2= new LinkedList<TreeNode>();
      
        queue1.add(p);
        queue2.add(q);
    
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            p = queue1.poll();
            q = queue2.poll();
            
          if (p == null && q == null) continue;
             if (p == null || q == null) return false;
            if (p.val != q.val) return false;
           
           
            
            queue1.add(p.left);
            queue2.add(q.left);
            queue1.add(p.right);
            queue2.add(q.right);
        }
        return true;
    }
}



Method 3: using 1 queue (same as above)

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {

  Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
    
        while(!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            
          if (p == null && q == null) continue;
             if (p == null || q == null) return false;
            if (p.val != q.val) return false;
           
           
            
            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }
        return true;
    }
} 
