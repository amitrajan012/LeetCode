package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++) {
        		dp[i+1] = dp[i]+nums[i]; //dp at index i+1 stores the sum of array up to ith index
        		for(int j=0;j<i+1;j++) {
        			if(dp[i+1]-dp[j] == k) res++;
        		}
        }
    		return res;
    }
    
    public int subarraySum2(int[] nums, int k) {
    		int sum = 0, res = 0;
    		Map<Integer, Integer> preSum = new HashMap<>();
    		preSum.put(0, 1);
    		
    		for(int i=0;i<nums.length;i++) {
    			sum += nums[i];
    			if(preSum.containsKey(sum-k)) {
    				res += preSum.get(sum-k);
    			}
    			preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
    		}
    		
    		return res;
    }
}
