/*Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
 

Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.*/

Solution:
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int a[][]=new int[len][len];
        char str[]=s.toCharArray();
        for(int i=0;i<len;i++)
        {
            a[i][i]=1;
        }
        int j;
        for(int l=2;l<=len;l++)
        {
            for(int i=0;i<=len-l;i++)
            {
                j=i+l-1;
                if(l==2 && str[i]==str[j])
                {
                    a[i][j]=2;
                }
                else if(str[i]==str[j])
                {
                    a[i][j]=2+a[i+1][j-1];
                }
                else 
                {
                    a[i][j]=Math.max(a[i][j-1],a[i+1][j]);
                }
            }
        }
        return a[0][len-1];
    }
}
