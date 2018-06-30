package medium;
/*
 * https://leetcode.com/problems/wiggle-subsequence/description/
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int size = nums.length;
        if(size == 0) return 0;
        
        int[] up = new int[size]; //Lengths of longest wiggle subsequence of numbers till the corresponding index with positive difference between last two numbers
        int[] down = new int[size]; //Here the difference between last two numbers is negative
        
        //For i=0, there is only one number and it can be used as a subsequence
        up[0] = 1; down[0] = 1;
        for(int i=1;i<size;i++) {
        		if(nums[i] > nums[i-1]) {
        			up[i] = down[i-1]+1;
        			down[i] = down[i-1];
        		}else if(nums[i] < nums[i-1]) {
        			down[i] = up[i-1]+1;
        			up[i] = up[i-1];
        		}else {
        			down[i] = down[i-1];
        			up[i] = up[i-1];
        		}
        }
    		return Math.max(up[size-1], down[size-1]);
    }
}
