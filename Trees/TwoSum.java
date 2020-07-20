/*Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False*/

Solution:
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> hs=new ArrayList<>();
        helper(hs,root);
        int l=0; int r=hs.size()-1;
        
        while(l<r)
        {
            int sum=hs.get(l)+hs.get(r);
            if(sum==k)
            {
                return true;
            }
            else if(sum<k)
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return false;
    }
    public void helper(ArrayList<Integer> hs,TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        helper(hs,root.left);
        hs.add(root.val);
        helper(hs,root.right);
    }
}
