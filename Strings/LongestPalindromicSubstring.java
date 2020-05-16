/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"*/

class Solution {
    public String longestPalindrome(String s) {
        
        
        if(s.length()==0)
        {
            return "";
        }
        int maxlen=1;
        int start=0;
      
        for(int i=1;i<s.length();i++)
        {
            int l=i-1;
            int r=i;
            while( l>=0 && r<s.length() &&s.charAt(l)==s.charAt(r))
            {
               
                if(r-l+1>maxlen)
                {
                    maxlen=r-l+1;
                    start=l;
                
                }
                l--;
                r++;
            }
            
             l=i-1;
             r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                  if(r-l+1>maxlen)
                {
                    maxlen=r-l+1;
                    start=l;
                 
                }
                l--;
                r++;
            }
        }
        
        int m=start+maxlen;
        
        StringBuffer sb=new StringBuffer();
        for(int i = start;i<m;i++)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
