/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.*/

Solution:
class Solution {
    public List<String> letterCombinations(String digit) {
         List<String> result=new ArrayList<>();
        if(digit==null || digit.length()==0)
        {
            return result;
        }
        String[] arr={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      
        int index=0;
        StringBuilder current=new StringBuilder();
        compute(result,digit,current,index,arr);
        return result;
    }
    public void compute(List<String> result, String digit,StringBuilder current,int index,String[] arr)
    {
        if(index==digit.length())
        {
            result.add(current.toString());
            return;
        }
        int num=Integer.parseInt(String.valueOf(digit.charAt(index)));
        String letter=arr[num];
       for(int i=0;i<letter.length();i++)
       {
             compute(result,digit,current.append(letter.charAt(i)),index+1,arr);
            current.deleteCharAt(current.length()-1);
        }

    }
}


Iterative:
class Solution {
    public List<String> letterCombinations(String digit) {
        LinkedList<String> q=new LinkedList<>();
      
        if(digit==null || digit.length()==0)
        {
            return q;
        }
        String[] arr={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      
        int index=0;
        q.add("");
        StringBuilder current=new StringBuilder();
    String temp="";
        for(int i=0;i<digit.length();i++)
        {
            int num=Integer.parseInt(String.valueOf(digit.charAt(i)));
            String s=arr[num];
          
            while(q.peek().length()==i)
            {
            temp= q.remove();
            for(int j=0;j<s.length();j++)
            {
                q.add(temp+s.charAt(j));
            }
            }
        }
        return q;
    }
    
}
