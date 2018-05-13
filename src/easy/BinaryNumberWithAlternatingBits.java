package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 *
 */
public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		if(n == 0 || n == 1) return true; //Base case
		int b = n & 1; //First bit
		while(n > 0) {
			n = n >> 1;
			int temp = n & 1;
			if(temp == b) return false;
			b = temp;
		}
		return true;
    }
}
