/*Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

Solution:
Recursive:
	// Function to find length of longest increasing subsequence
	public static int LIS(int[] A, int i, int n, int prev)
	{
		// Base case: nothing is remaining
		if (i == n) {
			return 0;
		}

		// case 1: exclude the current element and process the
		// remaining elements
		int excl = LIS(A, i + 1, n, prev);

		// case 2: include the current element if it is greater
		// than previous element in LIS
		int incl = 0;
		if (A[i] > prev) {
			incl = 1 + LIS(A, i + 1, n, A[i]);
		}

		// return maximum of above two choices
		return Integer.max(incl, excl);
	}

	// Program for Longest Increasing Subsequence
	public static void main(String[] args)
	{
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.print("Length of LIS is "
						+ LIS(A, 0, A.length, Integer.MIN_VALUE));
	}
}

Solution 2:Efficient:
public int lengthOfLIS(int[] nums) 
	{
		// Base case
		if(nums.length <= 1) 
			return nums.length;

		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];

		// Fill each position with value 1 in the array
		for(int i=0; i < nums.length; i++)
			T[i] = 1;


		// Mark one pointer at i. For each i, start from j=0.
		for(int i=1; i < nums.length; i++)
		{
			for(int j=0; j < i; j++)
			{
				// It means next number contributes to increasing sequence.
				if(nums[j] < nums[i])
				{
					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					if(T[j] + 1 > T[i])
					{
						T[i] = T[j] + 1;
					}
				}
			}
		}

		// Find the maximum length from the array that we just generated 
		int longest = 0;
		for(int i=0; i < T.length; i++)
			longest = Math.max(longest, T[i]);

		return longest;
	}
