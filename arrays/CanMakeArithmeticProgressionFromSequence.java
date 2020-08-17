/*Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.

 

Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Example 2:

Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.*/


Solution :BF

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    int diff=Math.abs(arr[0]-arr[1]);
    for(int i=0;i<arr.length-1;i++)
    {
        int new_diff=Math.abs(arr[i]-arr[i+1]);
        if(diff!=new_diff)
        {
            return false;
        }
        
    }
    return true;
    }
}

Optimized:
AP = a, a + d, a + 2d, . . . , a + (n - 1)d
T1 = a - first term of AP also min value in AP for d > 0
Tn = a + (n - 1)d - nth term of AP also the max value in AP for d > 0

Tn - T1 = (n - 1)d => d = (max(arr) - min(arr)) / (n - 1) common difference of our AP.

Now we will add all elements of our array in HashSet why ? to fast lookup.

Now we know first term and the common difference of our AP we can generate n-terms and then check if any term is not in our set return false else continue.


  public boolean canMakeArithmeticProgression(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int mi = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, n = arr.length;
        for (int a : arr) {
            mi = Math.min(mi, a);
            mx = Math.max(mx, a);
            seen.add(a);
        }
        int diff = mx - mi;
        if (diff % (n - 1) != 0) {
            return false;
        }
        diff /= n - 1;
        while (--n > 0) {
            if (!seen.contains(mi)) {
                return false;
            }
            mi += diff;
        }
        return true;
    }
If we found all terms return true.
