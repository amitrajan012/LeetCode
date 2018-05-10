package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 *
 */
public class LongestContinuingIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int currentLen = 1, maxLen = 1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i] > nums[i-1]) {
				currentLen++;
			}else {
				if(currentLen>maxLen) maxLen = currentLen;
				currentLen = 1; //Reset
			}
		}
		return Math.max(currentLen, maxLen);
    }
}
