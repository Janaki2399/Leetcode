/*Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".*/

Solution:
class Solution {
    public String removeDuplicates(String S) {
    Stack<Character> st=new Stack<>();
    for(int i=0;i<S.length();i++)
    {
        if(st.isEmpty() || st.peek()!=S.charAt(i))
        {
            st.push(S.charAt(i));
           
        }
        else if(st.peek()==S.charAt(i))
        {
            char poppedCharacter=st.pop();           
       }
    }
    StringBuffer sb=new StringBuffer();
    while(!st.isEmpty())
    {
        char poppedCharacter=st.pop();
        sb.append(poppedCharacter);
    }
    StringBuffer result=sb.reverse();
    return result.toString();
    }
}

Using StringBuilder:

class Solution {
    public String removeDuplicates(String S) {
  StringBuilder sb=new StringBuilder();
    for(int i=0;i<S.length();i++)
    {
        int size=sb.length();
            
        if(size==0 || sb.charAt(size-1)!=S.charAt(i))
        {
            sb.append(S.charAt(i));
        }
        else
        {
            sb.deleteCharAt(size-1);
        }
    }
    return sb.toString();
    }
}
Using Two Pointers:

  public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }
