/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

Method 1: Iterative with queue 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> big= new ArrayList<>();
        
        if(root ==null)
        {
            return big;
        }
      
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
      
        while(!q.isEmpty())
        {
             List<Integer> small=new ArrayList<>();
            int size=q.size();
            while(size > 0)
            {
            
            if(q.peek().left!= null)
            {
                q.add(q.peek().left);
              
            }
            if(q.peek().right !=null)
            {
                q.add(q.peek().right);
               
            }
                 small.add(q.poll().val);
            size--;
            }
            
            big.add(small);
        }
        
        return big;
    }
}

Method 2 : With recursion 

public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
