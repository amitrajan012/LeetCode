package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 */
public class NumberOfLongestIncreasingSubsequnce {
    public int findNumberOfLIS(int[] nums) {
    		if(nums == null || nums.length == 0) return 0;
    		int[] dp = new int[nums.length]; //Represents the length of longest subsequence till the corresponding index
    		int[] count = new int[nums.length]; //Represents their count
    		Arrays.fill(dp, 1); Arrays.fill(count, 1);
    		
    		for(int i=1;i<nums.length;i++) {
    			for(int j=0;j<i;j++) {
    				if(nums[j] < nums[i]) {
    					if(dp[j]+1 > dp[i]) {
    						dp[i] = dp[j]+1;
    						count[i] = count[j];
    					}else if(dp[j]+1 == dp[i]) {
    						count[i] += count[j];
    					}
    				}
    			}
    		}
    		
    		//Find maximum and its count
    		int max = 0, res = 0;
    		for(int i=0;i<dp.length;i++) {
    			if(dp[i] > max) {
    				max = dp[i];
    				res = count[i];
    			}else if(dp[i] == max) {
    				res += count[i];
    			}
    		}
    		return res;
    }
}
