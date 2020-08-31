Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

 

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.

Solution:

class Solution {
    public int findLucky(int[] arr) {
        int max=-1;
        int[] num=new int[500];
        for(int i=0;i<arr.length;i++)
        {
            num[arr[i]]++;
          
            
        }
         for(int i=1;i<num.length;i++)
        {
            if(num[i]==i)
            {
                max=Math.max(num[i],max);
            }
            
        }
        
        return max;
    }
}

O(1) space solution:(Leetcode discussions)
The idea is to use the input array to store counts. This approach, however, is quite tricky to implement correctly!

We can think of our array as a linked list, where arr[i] points to arr[arr[i] - 1] and so on, until the element that points to itself, or its outside of the array (and we do not care about that elements, per the intuition above).

After we visit arr[arr[i] - 1], we can use that element to track the count of arr[i]. For the count, we will use a negative value to distinguish between pointers and counts.

#define BEAST_MODE
int findLucky(vector<int>& arr) {
    for (auto i = 0; i < arr.size(); ++i) {
        auto p = i, val = arr[i];
        while (val > 0 && val <= arr.size()) {
            auto n_val = arr[val - 1];
            arr[val - 1] = min(0, arr[val - 1]) - 1;
            if (val - 1 <= i || val - 1 == p)
                break;
            p = val - 1;
            val = n_val;
        }      
    }
    for (auto i = arr.size(); i > 0; --i)
        if (-arr[i - 1] == i)
            return i;
    return -1;
}
