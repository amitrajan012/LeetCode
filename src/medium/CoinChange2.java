package medium;
/*
 * https://leetcode.com/problems/coin-change-2/description/
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        //Classic Knapsack Problem
    		//dp[i][j]: The number of combinations to make amount j using the first i coins
    		//dp[i][j] = Case 1: Don't use ith coin : dp[i-1][j]
    		//Case 2: Use ith coin dp[i][j-coins[i]] as we need to make sum as j-coins[i] and then include ith coin to make the sum j
    		//Initialization: dp[i][0] = 1
    	
    		int[][] dp = new int[coins.length+1][amount+1];
    		dp[0][0] = 1;
    		
    		for(int i=1;i<=coins.length;i++) {
    			dp[i][0] = 1;
    			for(int j=1;j<=amount;j++) {
    				dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
    			}
    		}
    		return dp[coins.length][amount];
    }
}
