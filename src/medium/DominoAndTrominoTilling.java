package medium;
/*
 * https://leetcode.com/problems/domino-and-tromino-tiling/description/
 */
public class DominoAndTrominoTilling {
    public int numTilings(int N) {
    		//dp[0] = 1, dp[1] = 1, dp[2] = 2, dp[3] = 5, dp[4] = 11, dp[5] = 24
    		//dp[n] = dp[n-1] + dp[n-2] + 2(dp[n-3]+dp[n-4]+...+dp[0]) = 2dp[n-1] + dp[n-3]
    	
    		//Base case
    		if(N == 0) return 0;
    		if(N == 1) return 1;
    		if(N == 2) return 2;
    		int M = 1000000007;
    		int[] dp = new int[N+1];
    		dp[0] = 1; dp[1] = 1; dp[2] = 2;
    		for(int i=3;i<=N;i++) {
    			dp[i] = 2*dp[i-1] % M + dp[i-3] % M;
    			dp[i] %= M;
    		}
    		
    		return dp[N];
    }
}
