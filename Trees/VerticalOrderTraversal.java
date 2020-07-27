



/*Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.

*/


Solution:

 //The values in the array list is not sorted
 
class Solution {
      class Obj
{
    TreeNode node;
    int dis;
    public Obj(TreeNode root,int dis)
    {
        this.node=root;
        this.dis=dis;
    }
        
    
}
   public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> big=new ArrayList<>();
        Queue<Obj> q=new LinkedList<>();
        TreeMap<Integer,ArrayList<TreeNode>> t=new TreeMap<>();
        q.add(new Obj(root,0));
        while(!q.isEmpty())
        {
            
           int count=q.size();
            for(int i=0;i<count;i++)
            {
            Obj ele=q.poll(); 
            
            if(t.containsKey(ele.dis))
            {
                t.get(ele.dis).add(ele.node);
            }
            else
            { ArrayList<TreeNode> ar=new ArrayList<>();
             ar.add(ele.node);
                t.put(ele.dis,ar);
            }
            if(ele.node.left!=null)
            {
                q.add(new Obj(ele.node.left,(ele.dis)-1));
            }
            if(ele.node.right!=null)
            {
                q.add(new Obj(ele.node.right,(ele.dis)+1));
            }
            }
            
        }
        
   int min= t.firstKey();
    int max=t.lastKey();
       
    for(int i=min;i<=max;i++)
    {
        ArrayList arr=new ArrayList<>();
        for(int j=0;j<t.get(i).size();j++)
        {
            arr.add(t.get(i).get(j).val);
        }
        big.add(arr);
    }
      return big;
    }
  
}

//diff method
class Pair{
        TreeNode node;
        int x;  //horizontal
        int y;  //depth
        Pair(TreeNode n, int x, int y)
        {
            node = n;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List<Pair>> map = new HashMap<>(); //x -> list (some nodes might have same y in the list)
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        int min = 0, max = 0;
        while(!q.isEmpty())
        {
            Pair p = q.remove(); 
            
            min = Math.min(min, p.x);
            max = Math.max(max, p.x);
            
            if(!map.containsKey(p.x)) 
                map.put(p.x, new ArrayList<>());
            map.get(p.x).add(p);
            
            if(p.node.left!=null) q.add(new Pair(p.node.left, p.x-1, p.y+1));
            if(p.node.right!=null) q.add(new Pair(p.node.right, p.x+1, p.y+1));
        }        

        for(int i=min; i<=max; i++)
        {
            Collections.sort(map.get(i), new Comparator<Pair>(){
                public int compare(Pair a, Pair b)
                {
                    if(a.y==b.y) //when y is equal, sort it by value
                        return a.node.val - b.node.val;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }
            });
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<map.get(i).size(); j++)
            {
                list.add(map.get(i).get(j).node.val);
            }
            lists.add(list);
        }
        return lists;   
    }
