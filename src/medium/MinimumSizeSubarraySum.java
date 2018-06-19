package medium;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        
        for(int i=0;i<nums.length;i++) {
        		if(nums[i] == s) return 1;
        		sum += nums[i];
        		while(sum >= s) {
        			minLen = Math.min(minLen, i-left+1);
        			sum -= nums[left];
        			left++;
        		}
        }
        
    		return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
