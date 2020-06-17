/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.*/


Solution:
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
       for(int i=0;i<strs.length;i++)
       {
           String s=strs[i];
           char[] ch=new char[26];
           for(int j=0;j<s.length();j++)
           {
               int val=(int)s.charAt(j)-'a';
               ch[val]++;
                
           }
           String str=String.valueOf(ch);
           
          
             
           if(!hm.containsKey(str))
           {
               hm.put(str,new ArrayList<>());
           }
             hm.get(str).add(s);
         
       }
  return new ArrayList<>(hm.values());
    }
}
