/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/

Solution:
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> arr=new ArrayList<Integer>();
        int[] count=new int[26];
        for(int i=0;i<p.length();i++)
        {
            count[p.charAt(i)-'a']++;
        }
        int i=0,j=0;
        int diff=p.length();
        for(j=0;j<s.length();j++)
        {
            
            count[s.charAt(j)-'a']--;
              if(count[s.charAt(j)-'a']>=0)
           {
               diff--;
                   if(diff==0)
            {
                arr.add(i);
             } 
           }
            
            
            if((j-i+1)>=p.length())
            {
               
             count[s.charAt(i)-'a']++;
                 if(count[s.charAt(i)-'a']>=1)
              {
               diff++;
                }
            i++;
            }                                               
        }
        return arr;
    }
}
