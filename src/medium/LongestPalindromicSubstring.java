package medium;
/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		//Base case
		if(s == null || s.isEmpty()) {
			return null;
		}else if(s.length() == 1) {
			return s;
		}
		
		String longest = s.substring(0, 1);
		for(int i=0;i<s.length();i++) {
			//Get longest Palindrome with center at i
			String temp = getLongestPalindrome(s, i, i);
			if(temp.length() > longest.length()) {
				longest = temp;
			}
			//Get longest Palindrome with center at i and i+1
			temp = getLongestPalindrome(s, i, i+1);
			if(temp.length() > longest.length()) {
				longest = temp;
			}
		}
		return longest;
    }
	
	private String getLongestPalindrome(String s, int begin, int end) {
		while(begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
	}
}
