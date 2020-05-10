/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        String largestprefix="";
        if(strs.length == 0 || strs == null)
        {
            return "";
        }
      for(int i=0;i<strs[0].length();i++)
      {
          int flag=0;
          char c=strs[0].charAt(i);
          for(int j=1;j<strs.length;j++)
          {
              if(i == strs[j].length() || strs[j].charAt(i)!=c  )
              {
                  flag=1;
                  return largestprefix;
              }
              
          }
          if(flag==0)
          {
              largestprefix+=c;
              
          }
      }
        return largestprefix;
    }
}
