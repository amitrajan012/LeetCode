package medium;
/*
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
    		int res = 0;
        for(int i = 0; i < nums.length; i++) res ^= nums[i];
        return res;
    }
    
    public int singleNonDuplicate1(int[] nums) {       	
    		if (nums.length == 1) return nums[0];

    		for (int i=0;i<nums.length-1;i+=2)
    		{
    			if (nums[i] != nums[i+1]) return nums[i];
    		}
    		return nums[nums.length-1];
    }
}
