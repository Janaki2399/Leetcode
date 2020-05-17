/*We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false*/

Solution:
class Solution {
    public boolean rotateString(String a, String b) {
        
        if(a.length() !=b.length())
        {
            return false;
        }
        
        String str=a+a;
        int i=0,j=0;
        int start=0;
        while(i<str.length() && j<b.length())
        {
            if(str.charAt(i)==b.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i=++start;
                
                j=0;
            }
        }
        if(j==b.length())
        {
            return true;
        }
        return false;
    }
}
