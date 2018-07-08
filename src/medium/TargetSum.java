package medium;
/*
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S);
    }

	private int helper(int[] nums, int index, int S) {
		if(index == nums.length) {
			if(S==0) return 1;
			else return 0;
		}
		else {
			return helper(nums, index+1, S-nums[index]) + helper(nums, index+1, S+nums[index]);
		}
	}
}
