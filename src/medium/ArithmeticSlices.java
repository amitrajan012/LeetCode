package medium;
/*
 * https://leetcode.com/problems/arithmetic-slices/description/
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int res = 0;
        for(int i=2;i<A.length;i++) {
        		if(2*A[i-1] == A[i-2]+A[i]) {
        			dp[i] = dp[i-1]+1;
        			res += dp[i];
        		}
        }
    		return res;
    }
}
