package medium;
/*
 * https://leetcode.com/problems/integer-replacement/description/
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
    		return helper(n);
    }

	private int helper(long n) {
		if(n == 1) return 0;
		if(n % 2 == 0) {
			return helper(n/2)+1;
		}else {
			return Math.min(helper(n+1), helper(n-1))+1;
		}
	}
}
