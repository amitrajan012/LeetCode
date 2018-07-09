package medium;
/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j] : Length of longest palindromic subsequence of substring(i, j) where i and j represents left and right indices int the string
    		//dp[i][j] = dp[i+1][j-1] + 2 if charAt(i) == charAt(j)
    		//dp[i][j] = Math.max(dp[i+1][j] + dp[i][j-1])
    		//Initialization: dp[i][i] = 1
    		int[][] dp = new int[s.length()][s.length()];
    		
    		//Need to iterate from last index of the string as we need dp[i+1][j] for evaluating dp[i][j]
    		for(int i=s.length()-1;i>=0;i--) {
    			dp[i][i] = 1;
    			//Need to iterate from start as j-1 is needed to evaluate j
    			for(int j=i+1;j<s.length();j++) {
    				if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
    				else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
    			}
    		}
    		return dp[0][s.length()-1];
    }
}
