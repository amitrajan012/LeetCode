package medium;
/*
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int leftMostGoodPosition = nums.length - 1;
	    for (int i = nums.length - 1; i >= 0; i--) {
	      if (i + nums[i] >= leftMostGoodPosition) {
	        leftMostGoodPosition = i;
	      }
	    }
	    return leftMostGoodPosition == 0;
	}
}
