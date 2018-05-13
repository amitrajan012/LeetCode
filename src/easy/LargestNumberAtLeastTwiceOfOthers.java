package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 *
 */

public class LargestNumberAtLeastTwiceOfOthers {
	public int dominantIndex(int[] nums) {
		int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, index = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > max) {
				secondMax = max;
				max = nums[i];
				index = i;
			}else if(nums[i] > secondMax) {
				secondMax = nums[i];
			}
		}
		return (max >= 2*secondMax) ? index : -1 ;
    }
}
