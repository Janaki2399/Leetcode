/*Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.*/

Solution:

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        //heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            minHeap.add(entry);
            if (minHeap.size() > k) 
            {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++)
        {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res[i]=entry.getKey();
        }
        return res;
    }
}
