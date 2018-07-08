package medium;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/matchsticks-to-square/description/
 */
public class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
    		if(nums == null || nums.length < 4) return false;
        int sum = 0;
        for(int num: nums) {
        		sum += num;
        }
        if(sum % 4 != 0) return false;
        int side = sum/4;
        Arrays.sort(nums);
    		return DFS(nums, new int[4], nums.length-1, side);
    }

	private boolean DFS(int[] nums, int[] sums, int index, int side) {
		if(index == -1) {
			if(sums[0] == side && sums[1] == side && sums[2] == side) {
				return true;
			}
			return false;
		}
		
		for(int i=0;i<4;i++) {
			if(sums[i]+nums[index] > side) continue;
			sums[i] += nums[index];
			if(DFS(nums, sums, index-1, side)) return true;
			sums[i] -= nums[index];
		}
		return false;
	}
}
