
Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr.

 

Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000

Solutions:
BruteForce:
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum=0;
        for(int i=1;i<=arr.length;i+=2)
        {
            for(int j=0;j<=arr.length-i;j++)
            {
                for(int k=j;k<i+j;k++)
                {
                    sum=sum+arr[k];
                }
            }
        }
        return sum;
    }
}

TC -O(n^2)
public int sumOddLengthSubarraysFirst(int[] arr) {
    int result = 0;
    for (int i = 0; i < arr.length; ++i) {
        int currSum = 0;     // sum of the current subarray arr[i, j]. Note that both i and j are inclusive so the size is j - i + 1.
        for (int j = i; j < arr.length; ++j) {
            currSum += arr[j];
            if ((j - i + 1) % 2 == 1) result += currSum;
        }   
    }
    return result;
}

TC- O(n)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
      int result = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int endingHere = i + 1;
            int startingHere = n - i;
            int totalSubarrays = endingHere * startingHere;
           
            result += ((totalSubarrays +1)/2) * arr[i];
        }
        
        return result;
    }
}
