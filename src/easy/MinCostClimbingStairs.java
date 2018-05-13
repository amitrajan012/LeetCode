package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 */

public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		//Dynamic Programming
		//Let dp[i] be the minimum cost to reach stair i
		//Base cases: dp[0] = cost[0], dp[1]=cost[1]
		//dp[i] = cost[i]+min(dp[i-1], dp[i-2])
		int len = cost.length;
		int[] dp = new int[len];
		dp[0] = cost[0]; dp[1] = cost[1];
		
		for(int i=2;i<len;i++) {
			dp[i] = cost[i]+(int)Math.min(dp[i-1], dp[i-2]);
		}
		
		return Math.min(dp[len-1], dp[len-2]);
    }

}
