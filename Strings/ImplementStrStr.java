/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().*/

class Solution {
    public int strStr(String haystack, String needle) {

 if(needle.length()==0)
        {
            return 0;
        }
        if(haystack.length()==0 && needle.length()!=0)
        {
            return -1;
        }
        int i=0;
        int j=0;
        int start=0;
       while(i<haystack.length() && j<needle.length())
       {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }
           else
           {
               i=++start;
               j=0; 
           }
        }
        
        if(j==needle.length())
        {
            return start;
        }
        else
        {
            return -1;
        }
        
     }
}

//Efficient Solution :KMP Algorithm for substring search

class Solution {
    public int strStr(String A, String B) {
       
        if(B.length()==0)
        {
            return 0;
        }
        if(A.length()==0 && B.length()!=0)
        {
            return -1;
        }
        int[] arr=new int[B.length()];
        arr[0]=0;
        int j=0;
        int i=1;
        while(i<B.length() && j<arr.length)
        {
            if(B.charAt(i)==arr[j])
            {
                arr[i]=j+1;
                i++;
                j++;
            }
            else
            {
                if(j!=0)
                {
                int val=arr[j-1];
                j=val;
                }
                else
                {
                
                    arr[i]=0;
                    i++;
                }
                
            }
        }
         i=0;
         j=0;
        int start=0;
        while(i<A.length() && j<B.length())
        {
            if(A.charAt(i)==B.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if(j!=0)
                {
                    int val=arr[j-1];
                    j=val;
                }
                else
                {
                    
                    i=++start;
                }
            }
        }
        if(j==B.length())
        {
            return i-j;
        }
        else
        {
            return -1;
        }
        
        
    }
}

