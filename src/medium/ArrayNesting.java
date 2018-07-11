package medium;
/*
 * https://leetcode.com/problems/array-nesting/description/
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
    		int res = 0;
    		for(int i=0;i<nums.length;i++) {
    			int k = i;
    			int size = 0;
    			while(nums[k] >= 0) {
    				int temp = nums[k];
    				nums[k] = -1;
    				k = temp;
    				size++;
    			}
    			res = Math.max(size, res);
    		}
    		return res;
    }
}
