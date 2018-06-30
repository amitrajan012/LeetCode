package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/combination-sum-iv/description/
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
    		int[] dp=new int[target+1];
    		dp[0] = 1;
    		Arrays.sort(nums);
    		
    		for(int i=1;i<dp.length;i++) {
    			for(int j=0;j<nums.length;j++) {
    				if(nums[j] <= i) dp[i] += dp[i-nums[j]];
    				else break;
    			}
    		}
    		
    		return dp[target];
    }
}
