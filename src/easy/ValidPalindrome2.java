package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 */
public class ValidPalindrome2 {
	public boolean validPalindrome(String s) {
		if(s == null || s.length() == 1) return true; //Base case
		int start = 0, end = s.length()-1;
		while(start < end && s.charAt(start) == s.charAt(end)) {
			start++; end--;
		}
		
		if(start>=end) return true;
		
		if(isPalinDrome(s, start+1,end) || isPalinDrome(s, start, end-1)) return true;
		return false;
    }

	private boolean isPalinDrome(String s, int start, int end) {
		while(start<end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++; end--;
			}else {
				return false;
			}
		}
		return true;
	}
}
