package medium;
/*
 * https://leetcode.com/problems/new-21-game/description/
 */
public class New21Game {
    public double new21Game(int N, int K, int W) {
    		//dp[i] = {dp[i-1] + dp[i-2] + ... + dp[i-W]}/W
    		//This can be represented as {sum[i-1] - sum[i-W-1]}/W as well
        if(K == 0) return 1;
        int max = K+W-1;
        double[] dp = new double[max+1];
        dp[0] = 1;
        for(int i=1;i<=max;i++) {
        		dp[i] = dp[i-1];
        		if(i <= W) {
        			dp[i] += dp[i-1]/W;
        		}else {
        			dp[i] += (dp[i-1] - dp[i-W-1])/W;
        		}
        		
        		if(i > K) {
        			dp[i] -= (dp[i-1] - dp[K-1])/W;
        		}
        }
    		return dp[N]-dp[K-1];
    }
}
