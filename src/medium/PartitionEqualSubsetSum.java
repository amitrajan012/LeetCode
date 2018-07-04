package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
    		int sum = 0;
    		for(int i=0;i<nums.length;i++) {
    			sum += nums[i];
    		}
    		if(sum % 2 == 1) return false;
    		sum = sum/2;
    		Arrays.sort(nums);
    		return helper(sum, nums.length-1, nums);
    }

	private boolean helper(int sum, int pointer, int[] nums) {
		if(pointer < 0) return false;
		if(sum == nums[pointer]) return true;
		if(sum < nums[pointer]) return false;
		return helper(sum-nums[pointer], pointer-1, nums) || helper(sum, pointer-1, nums); //The key is either to include the number or not
	}
}
