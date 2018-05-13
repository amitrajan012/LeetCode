package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/rotate-string/description/
 *
 */

public class RotateString {
	public boolean rotateString(String A, String B) {
		if(A.length() != B.length()) return false; //Base case
		return (A+A).contains(B);
    }

}
