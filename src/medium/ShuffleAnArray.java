package medium;

/*
 * https://leetcode.com/problems/shuffle-an-array/description/
 */
public class ShuffleAnArray {

}

class Solution {
	int[] original;
    public Solution(int[] nums) {
        original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    		int[] res = new int[original.length];
    		for(int i=0;i<original.length;i++) {
    			int r = (int)(Math.random()*(i+1));
    			res[i] = res[r];
    			res[r] = original[i];
    		}
    		return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
