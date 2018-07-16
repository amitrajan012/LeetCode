package medium;
/*
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        //dp[i][j] : max lenth of common subarray start at a[i] & b[j];
    		//dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0;
    		
    		int m = A.length, n = B.length;
    		int[][] dp = new int[m+1][n+1];
    		int max = 0;
    		for(int i=m-1;i>=0;i--) {
    			for(int j=n-1;j>=0;j--) {
    				dp[i][j] = (A[i]==B[j]) ? dp[i+1][j+1]+1 : 0;
    				max = Math.max(max, dp[i][j]);
    			}
    		}
    		return max;
    }
}
