package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
    		if(nums == null || nums.length <= 1) return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1;i<nums.length;i++) {
        		if(nums[i] == prev) return prev;
        		else prev = nums[i];
        }
        return Integer.MIN_VALUE;
    }
}
