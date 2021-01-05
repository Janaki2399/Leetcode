/*Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false*/

Solution:
class Solution {
    public boolean isMatch(String s, String p) {
        
    int i=0;
    int j=0;
    int start =-1;
    int fstart=-1;
   
    while(i<s.length() )
    {
        if( j<p.length()&&( p.charAt(j)=='?' || s.charAt(i)==p.charAt(j)))
        {
            i++;
            j++;
        }
       else if ( j<p.length() && p.charAt(j)=='*')
       {
       
           start=j;
          fstart=i;
           j++;
       }
      else if( start!=-1)
      {
          j=start+1;
        i=fstart+1;
         fstart++;
        
      }
        else
        {
           System.out.println(1);
           return false;
        }
    }
    while(j<p.length() && p.charAt(j)=='*')
    {
        j++;
    }
  
    return j==p.length();
    }
}
