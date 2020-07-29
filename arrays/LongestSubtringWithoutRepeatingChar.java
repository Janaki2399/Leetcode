/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

Solution:
Method 1:

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int res=0;
        HashSet<Character> hs=new HashSet<>();
        for(int j=0;j<s.length();j++)
        {    
            while(hs.contains(s.charAt(j)))
            {
                hs.remove(s.charAt(i));
                i++;
            }
            hs.add(s.charAt(j));
            res=Math.max(res,j-i+1);
            
        }
        return res;
    }
}


Method 2:
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);//for i to keep moving forward only (eg:abba)
            }
          
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);     
        }
        return ans;
    }
}
