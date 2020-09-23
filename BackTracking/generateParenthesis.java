/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/


SOlution:
BRuteforce :(TTL)
class Solution {
    public List<String> generateParenthesis(int n) {
        String oB="";
        for(int i=0;i<n;i++)
        {
            oB+="()";
        }
      //  System.out.println(oB);
    ArrayList<String> result=new ArrayList<>();
    AllParenthesis(oB,0,"",result);
    return result;
    }
  public void AllParenthesis(String oB,int index,String ns,ArrayList<String> result)
    {
        if(index==oB.length())
        {     
            int flag=0;
           Stack<Character> st=new Stack<>();
        
        for(int i=0;i<ns.length();i++)
        {
            if(ns.charAt(i)=='(')
            {
                st.push(ns.charAt(i));
            }
            else if(ns.charAt(i)==')')
            {
                if(st.isEmpty())
                {   
                    flag=1;
                    break;
                }
                   
               else if( st.peek()=='(')
                {
                   char c= st.pop();
                }
            }
        }
         if(flag==0 && st.isEmpty())
         {
            String temp=ns;
            if(!result.contains(ns))
            {
            result.add(ns);
            }
         }
   
            return ;
        }
      for(int i=0;i<oB.length();i++)
      {     
        AllParenthesis(oB,index+1,ns+oB.charAt(i),result);
      }
    }
 
}


Efficient:
class Solution
{
public List<String> generateParenthesis(int n) 
{
    List<String> result = new LinkedList<String>();
    if (n > 0) generateParenthesisCore("", n, n, result); 
    return result;
}

private void generateParenthesisCore(String prefix, int left, int right, List<String> result)
{
    if (left == 0 && right == 0) result.add(prefix);
    // Has left Parenthesis    
    if (left > 0) generateParenthesisCore(prefix+'(', left-1, right, result);
    // has more right Parenthesis
    if (right>left) generateParenthesisCore(prefix+')', left, right-1, result);
}
}

