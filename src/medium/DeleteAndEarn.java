package medium;
/*
 * https://leetcode.com/problems/delete-and-earn/description/
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
    		int n = 10001;
    		int[] dp = new int[n];
    		for(int num: nums) {
    			dp[num] += num;
    		}
    		
    		int take = 0, skip = 0;
    		for(int i=0;i<n;i++) {
    			int takei = skip + dp[i];
    			int skipi = Math.max(take, skip);
    			take = takei;
    			skip = skipi;
    		}
    		return Math.max(take, skip);
    }
}
