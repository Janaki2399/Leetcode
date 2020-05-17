/*Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].*/

Solution :Time Complexity -O(n)
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
    
        if(s1.length()>s2.length())
        {
            return false;
        }
        
        
        int[] letters=new int[26];
    
         int[] let=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            int val=(int)(s1.charAt(i)-'a');
            letters[val]++;
            
              int v=(int)(s2.charAt(i)-'a');
                let[v]++;
        }
        
        for(int i=0;i<s2.length()-s1.length();i++)
        {
           if(matches(letters,let))
            {
                //System.out.println(i);
               return true;
            }

                int v=(int)(s2.charAt(i+s1.length())-'a');
                let[v]++;
                
                int v2=(int)(s2.charAt(i)-'a');
                let[v2]--;
            
            
        }
          if(matches(letters,let))
          {
              return true;
          }
        return false;
    }
    public boolean matches(int[] letters,int[] let)
    {
         for(int i=0;i<26;i++)
        {
            if(letters[i]!=let[i])
            {
                return false;
            }
        }
        return true;
    }
}
