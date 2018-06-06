package medium;
/*
 * https://leetcode.com/problems/divide-two-integers/description/
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;        
        int sign = (dividend ^ divisor) < 0 ? -1 : 1;
        
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        long ans = 0;
        
        while(absDivisor <= absDividend) {
        		int numShift = 0;
        		while(absDividend >= (absDivisor << numShift)) {
        			numShift++;
        		}
        		
        		ans += 1<<(numShift-1);
        		absDividend -= absDivisor << (numShift-1);
        }
        
        return (int)(sign*ans);
	}
}
