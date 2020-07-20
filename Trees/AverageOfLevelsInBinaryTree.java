
/*Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.*/

Solution:

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Double> answer=new ArrayList<>();
        q.add(root);
        double sum=0.0;
        long count=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size>0)
            {
                root=q.poll();
                sum=sum+root.val;
                count++;
                if(root.left!=null)
                {
                    q.add(root.left);
                }
                if(root.right!=null)
                {
                    q.add(root.right);
                }
                size--;
            }
            double avg=sum/count;
            answer.add(avg);
            sum=0;
            count=0;
        }
        return answer;
    }
}
