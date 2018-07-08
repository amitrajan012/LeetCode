package medium;
/*
 * https://leetcode.com/problems/predict-the-winner/description/
 */
public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
    		int res = helper(nums, 0, nums.length-1);
    		return res>=0;
    }

	private int helper(int[] nums, int startIndex, int endIndex) {
		if(startIndex == endIndex) return nums[startIndex];
		else {
			return Math.max(nums[startIndex] - helper(nums, startIndex+1, endIndex), nums[endIndex]- helper(nums, startIndex, endIndex-1));
		}
	}
}
