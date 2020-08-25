/*Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.*/

Solution;
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] arr=new int[S.length()];
        ArrayList<Integer> hs=new ArrayList<>();
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)==C)
            {
                hs.add(i);
            }
        }
 
        for(int i=0;i<S.length();i++)
        {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<hs.size();j++)
            {
                if(Math.abs(i-hs.get(j))<min)
                {
                    min=Math.abs(hs.get(j)-i);
                }
            }
            arr[i]=min;
        }
        return arr;
    }
}
SOlution 2:
class Solution {
    public int[] shortestToChar(String S, char C) {
    int[] ans=new int[S.length()];
    int pos=-(S.length()-1);
    for(int i=0;i<S.length();i++)//looking left side
    {
        if(S.charAt(i)==C)
        {
            pos=i;
        }
        ans[i]=i-pos;
    }

    for(int i=pos-1;i>=0;i--)//looking right side
    {
        if(S.charAt(i)==C)
           {
               pos=i;
           }
         ans[i]=Math.min(ans[i],pos-i);
    }
    return ans;
    }
}
Solution 3:DP 

  public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == C ? 0 : n;
        for (int i = 1; i < n; ++i)
            res[i] = Math.min(res[i], res[i - 1] + 1);
        for (int i = n - 2; i >= 0; --i)
            res[i] = Math.min(res[i], res[i + 1] + 1);
        return res;
    }


