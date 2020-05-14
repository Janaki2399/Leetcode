Given an input string, reverse the string word by word.
Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Solution:
class Solution {
  public String reverseWords(String input) {
     char [] array = input.toCharArray();
	reverse(array,0,array.length-1);
      
	int end = 0; //pointer to state the start to reverse each word

	for(int i=0; i<array.length; i++){
        //skip the leading spaces,find the word's startPos[end, )
		if(array[i]!=' ' && (i==0 || array[i-1]==' ')){
			end=i; 
		}
		//find the word's edge[end,i]
		if(array[i]!=' '&&(i==array.length-1 || array[i+1]==' ')){ 
			reverse(array,end,i);
		}
	}
      // exclude both leading and tailing spaces
    int start=0; //where we get the final answer's pointer position
    for( int i=0;i<array.length; i++){
        //skip all leading spaces(s)
        if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) { 
				continue;
			}
        array[start] = array[i];
		start++;
    }
      //exclude the tailing space(s)
       if (start > 0 && array[start - 1] == ' ') {
			return new String(array, 0, start - 1);
		}
      //otherwise return to the start position
	return new String(array, 0, start);
  }

  public void reverse(char[] array, int left, int right){
    while(left<right){
      char temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}
