/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

*/
class Solution {
    public int[][] merge(int[][] intervals) {
    if(intervals==null || intervals.length==0)
    {
        return new int[0][0];
    }
    Arrays.sort(intervals,((x,y)->x[0]-y[0]));

        List<int[]> result=new ArrayList<>();
        int[] current=intervals[0];
        
        for(int i=1;i<intervals.length;i++)
        {
            if(current[1]>=intervals[i][0])
            {
                current[1]=Math.max(current[1],intervals[i][1]);
            }
            else
            {
                result.add(current);
                current=intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[0][0]);
}
}
//Time Complexity -O(nlogn)
