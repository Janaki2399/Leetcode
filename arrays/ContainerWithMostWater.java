/*Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49*/

class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int maxarea=0;
        int p1;
        int p2;
        int breadth;
        int distance=0;
        for(int i =0;i<height.length;i++)
        {
            p1=height[i];
            distance=0;
            for(int j=i+1;j<height.length;j++)
            {
                p2=height[j];
                distance++;
                breadth=Math.min(p1,p2);
                area=breadth*distance;
                if(area>maxarea)
                {
                    maxarea=area;
                }
            }
        }
        return maxarea;
    }
}
