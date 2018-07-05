package medium;
/*
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
    		int slow = 0, res = 0;
    		int[] count = new int[26];
    		for(int fast=0;fast<s.length();fast++) {
    			res = Math.max(res, ++count[s.charAt(fast)- 'A']);
    			while(count[s.charAt(slow)-'A'] + k < fast-slow+1) {
    				count[s.charAt(slow)-'A']--;
    				slow++;
    			}
    		}
    		
    		return Math.min(s.length(), res+k);
    }
}
