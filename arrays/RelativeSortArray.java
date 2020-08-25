/*Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
*/

Solution:

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count=new int[1001];
        int k=0;
        for(int i=0;i<arr1.length;i++)
        {
            count[arr1[i]]++;
        }
        for(int i=0;i<arr2.length;i++)
        {
         int count2=count[arr2[i]];
        while(count2>0)
        {
            arr1[k]=arr2[i];
            k++;
            count2--;
        }
        count[arr2[i]]=-1;
        }
        for(int i=0;i<count.length;i++)
        {
            if(count[i]>0)
            {
                while(count[i]>0)
                {
                arr1[k]=i;
                count[i]--;
                k++;
                }
                
            }
        }
    return arr1;
    }
}

If the condition 1<arr<1000 is not given use TreeMap
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }
        for(int n : map.keySet()){
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}

Time complexity of TreeMap:

Average case:

HashMap O(1)
TreeMap O(logn) -- since the underlying structure is a red-black tree
Worst case:

Hashmap O(n) -- in the case of a hashing collision
TreeMap O(logn)

