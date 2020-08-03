/*Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"*/

Solution:
class Solution {
    public String decodeString(String s) {
       Stack<Integer> numStack= new Stack<>();
       Stack<Character> charStack=new Stack<>();
        
        StringBuffer sb=new StringBuffer();
        int i=0;
      
        while(i<s.length())
        {
            if(Character.isDigit(s.charAt(i)))
            {
             int val=0;   
               while(Character.isDigit(s.charAt(i)))
               {
                   val=(val*10)+(s.charAt(i)-'0');
                   i++;
               }
                //System.out.println(val);
                numStack.push(val);
            }
            
            else if(Character.isLetter(s.charAt(i))||s.charAt(i)=='[')
            {               
            charStack.push( s.charAt(i));
                i++;
            }
            
           else if(s.charAt(i)==']')      
            {  
               
               StringBuffer temp=new StringBuffer();
               int count=numStack.pop();
              
               while(!charStack.isEmpty() && charStack.peek()!='[')
               {
                   char c=charStack.pop();
                   temp.append(c);
               }
               
                char bracket=charStack.pop();
               
                   temp.reverse();
               
            StringBuffer stringToPush=new StringBuffer();
               
               while(count>0)
                {
               stringToPush.append(temp.toString());
                count--;
                }
               
                String st=stringToPush.toString();
              
               int j=0;
               while(j<st.length())
               {
                   charStack.push(st.charAt(j));
                   j++;
               }
               i++;
            }
            
              
        }
        StringBuffer result=new StringBuffer();
        while(!charStack.isEmpty())
        {
            result.append(charStack.pop());
        }
        result.reverse();
        return result.toString();
    }
}
