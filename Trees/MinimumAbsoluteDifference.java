/*Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).*/

Solution:
public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
}

without global variables:
public int getMinimumDifference(TreeNode root) {
    	List<Integer> prev = new ArrayList<>(); // contains at most 1 value
    	int[] min = new int[]{Integer.MAX_VALUE};
    	inorder(root, prev, min);
    	return min[0];
    }
    
    private void inorder(TreeNode root, List<Integer> prev, int[] min) {
    	if (root == null) return;
    	
    	inorder(root.left, prev, min);
    	if (prev.isEmpty()) {
    		prev.add(root.val);
    	} else {
    		min[0] = Math.min(min[0], Math.abs(root.val - prev.get(0)));
    		prev.set(0, root.val);
    	}
    	inorder(root.right, prev, min);    	
    }

Solution 2:
long minDiff = Long.MAX_VALUE;
public int getMinimumDifference(TreeNode root) {
    helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    return (int)minDiff;
}
private void helper(TreeNode curr, long lb, long rb){
    if(curr==null) return;
    if(lb!=Long.MIN_VALUE){
        minDiff = Math.min(minDiff,curr.val - lb);
    }
    if(rb!=Long.MAX_VALUE){
    minDiff = Math.min(minDiff,rb - curr.val);
    }
    helper(curr.left,lb,curr.val);
    helper(curr.right,curr.val,rb);
}
