package medium;
/*
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
 */
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        //Maximum number of substring ending with a letter is the index of that letter in the alphabet
    		//For example: Substrings ending with d are abcd, bcd, cd, d
    		int[] count = new int[26];
    		int len = 0;
    		for(int i=0;i<p.length();i++) {
    			if(i>0 && ((p.charAt(i) - p.charAt(i-1) == 1) || (p.charAt(i-1) - p.charAt(i) == 25))) {
    				//Increment the length
    				len++;
    			}else {
    				len = 1;
    			}
    			
    			int index = p.charAt(i) - 'a';
    			count[index] = Math.max(count[index], len);
    		}
    		
    		int res = 0;
    		for(int c: count) {
    			res += c;
    		}
    		return res;
    }
}
