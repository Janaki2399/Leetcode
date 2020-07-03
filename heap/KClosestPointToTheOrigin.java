/*We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 */

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Solution: Inefficient
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer,Double> hm=new HashMap<>();
        for(int i=0;i<points.length;i++)
        {
            int c1=points[i][0];
            int c2=points[i][1];
           int sq1=c1*c1;
            int sq2=c2*c2;
            double dis=Math.sqrt(sq1+sq2);
            hm.put(i,dis);
        }
        
        PriorityQueue<Map.Entry<Integer,Double>> maxheap=new PriorityQueue<>(
            (a,b) -> Double.compare(b.getValue(),a.getValue()));
                                                                             
       for(Map.Entry<Integer,Double> entry :hm.entrySet())
      {
            maxheap.add(entry);
            if(maxheap.size()>k)
            {
                maxheap.poll();
            }
     }                         
   int[][] res = new int[k][2];
        for(int i=0;i<k;i++)
        {
            Map.Entry<Integer,Double> entry = maxheap.poll();
            int j=entry.getKey();
            res[i][0]=points[j][0];
            res[i][1]=points[j][1];
        }
        return res;                                                                           
                                    
                                                                             
    }
}

Solution2:Efficient

class Solution {
    public int[][] kClosest(int[][] points, int k) {
    
        PriorityQueue<int[]> maxheap=new PriorityQueue<>(
            (a,b) ->b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
                                                                             
       for(int[] p: points)
      {
            maxheap.add(p);
            if(maxheap.size()>k)
            {
                maxheap.poll();
            }
     }                         
   int[][] res = new int[k][2];
        for(int i=0;i<k;i++)
        {
            res[i]=maxheap.poll();
        }
        return res;                                                                           
                                    
                                                                             
    }
}
