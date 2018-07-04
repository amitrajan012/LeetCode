package medium;

import java.util.Random;

/*
 * https://leetcode.com/problems/random-pick-index/description/
 */
public class RandomPickIndex {

}

class Solution {
	int[] nums;
	Random R;
    public Solution(int[] nums) {
        this.nums = nums;
        R = new Random();
    }
    
    public int pick(int target) {
        int res = -1;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
        		if(nums[i] != target) continue;
        		count++;
        		if(R.nextInt(count) == 0) res = i;
        }
        return res;
    }
}