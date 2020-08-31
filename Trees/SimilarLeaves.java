/*Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
*/

Solution:

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> arr=new ArrayList<>();
    arr= leafValues(root1,arr);
    ArrayList<Integer> arr1=new ArrayList<>();
    arr1= leafValues(root2,arr1);
    if(arr.equals(arr1))
    {
        return true;
    }
    return false;
    }

    public ArrayList<Integer> leafValues(TreeNode root,ArrayList<Integer> arr)
    {
         if(root==null)
    {
        return arr;
    }
    if(root.left==null && root.right==null)
    {
        arr.add(root.val);
    }
   arr=leafValues(root.left,arr);
   arr= leafValues(root.right,arr);
      return arr;
    }
}

Better solution:
 public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.empty() && !s2.empty())
            if (dfs(s1) != dfs(s2)) return false;
        return s1.empty() && s2.empty();
    }

    public int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }
