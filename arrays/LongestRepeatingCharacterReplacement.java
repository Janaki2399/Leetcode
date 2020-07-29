/*Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

In one operation, you can choose any character of the string and change it to any other uppercase English character.

Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
 

Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.8*/
Solution:
class Solution {
    public int characterReplacement(String s, int k) {
    int[] count =new int[26];    
    int i=0;
    int maxcount=0;
    int maxLength=0;
    for(int j=0;j<s.length();j++)
    {
       maxcount = Math.max(maxcount,++count[s.charAt(j)-'A']);
       if(j-i+1-maxcount> k)
       {
           count[s.charAt(i)-'A']--;
           i++;
       }
        maxLength=Math.max(maxLength,j-i+1);
    }
    return maxLength;
    }
}


