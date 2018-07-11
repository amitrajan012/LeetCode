package medium;
/*
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {
	int count = 0;
    public int countSubstrings(String s) {
    		//Base case
    		if(s == null || s.length() == 0) return 0;
    		
    		for(int i=0;i<s.length();i++) {
    			extendPalindrome(s, i, i); //Odd length palindrome
    			extendPalindrome(s, i, i+1); //Even length palindrome
    		}
    		
    		return count;
    }

	private void extendPalindrome(String s, int left, int right) {
		while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--; right++;
		}
		
	}
}
