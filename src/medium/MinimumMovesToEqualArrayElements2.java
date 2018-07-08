package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 */
public class MinimumMovesToEqualArrayElements2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int res = 0;
        for(int num: nums) {
        		res = Math.abs(median - num);
        }
    		return res;
    }
}
