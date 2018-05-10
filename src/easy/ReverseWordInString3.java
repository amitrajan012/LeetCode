package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 */
public class ReverseWordInString3 {
	public String reverseWords(String s) {
        char[] result = s.toCharArray();
        int len = result.length;
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0;i<len;i++) {
        		if(result[i] == ' ' || i == len-1) {
        			endIndex= (i == len-1) ? i : i-1;
        			reverse(result, startIndex, endIndex);
        			startIndex = i+1;
        		}
        }
		return new String(result);
    }
	
	private void reverse(char[] charArr, int start, int end) {
        while(start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            ++start; 
            --end;
        }
    }
}
