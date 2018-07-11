package medium;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
    		if(pairs == null || pairs.length == 0) return 0;
    		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
    		int[] dp = new int[pairs.length];
    		Arrays.fill(dp, 1);
    		
    		for(int i=0;i<dp.length;i++) {
    			for(int j=0;j<i;j++) {
    				//i is next link in chain and j is previous
    				//If start of i(pairs[i][0]) is greater than end of j(pairs[j][1]) : length of chain is increases by 1
    				dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j]+1 : dp[j]);
    			}
    		}
    		return dp[pairs.length-1];
    }
}


