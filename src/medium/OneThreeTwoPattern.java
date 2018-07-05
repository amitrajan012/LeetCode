package medium;
/*
 * https://leetcode.com/problems/132-pattern/description/
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
    		for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;
    }
    
    public boolean find132pattern2(int[] nums) {
    		for(int j=0, min=Integer.MAX_VALUE;j<nums.length;j++) {
    			min = Math.min(min, nums[j]);
    			if(min == nums[j]) continue;
    			
    			for(int k=nums.length-1;k>j;k--) {
    				if(min < nums[k] && nums[k] < nums[j]) return true;
    			}
    		}
    		return false;
    }
}
