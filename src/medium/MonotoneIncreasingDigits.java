package medium;
/*
 * https://leetcode.com/problems/monotone-increasing-digits/description/
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
    		char[] chars = ("" + N).toCharArray();
    		int len = chars.length, j = len;
    		
    		for(int i=len-1;i>0;i--) {
    			if(chars[i] >= chars[i-1]) continue;
    			chars[i-1]--;
    			j = i;
    		}
    		
    		for (int i = j; i < len; i++) {
                chars[i] = '9';
    		}
        
    		return Integer.valueOf(new String(chars));
    }
}
