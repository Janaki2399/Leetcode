/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.*/

Solution;
class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        char l='a',r='a';
        int flag=0;
        while(i<j)
        {
            if(Character.isLetterOrDigit(s.charAt(i))&&Character.isLetterOrDigit(s.charAt(j)))
            {
                l=s.charAt(i);
                r=s.charAt(j);
                if(Character.isUpperCase(s.charAt(i)))
                {
                     l=Character.toLowerCase(s.charAt(i));
                }
                if(Character.isUpperCase(s.charAt(j)))
                {
                    r=Character.toLowerCase(s.charAt(j));
                }
                if(l==r)
                {
                    i++;
                    j--;
                }
                else
                {
                   
                    flag=1;
                    break;
                }
            }
             if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }
            if(!Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;
            }
            
        }
  return flag==1?false:true;
    }
}

Simplified:

class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(Character.isLetterOrDigit(s.charAt(i))&&Character.isLetterOrDigit(s.charAt(j)))
            {
                if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j)))
                {
                    i++;
                    j--;
                }
                else
                {
                   
                    return false;
                }
            }
             else if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }
            if(!Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;
            }
            
        }
  return true;
    }
}
