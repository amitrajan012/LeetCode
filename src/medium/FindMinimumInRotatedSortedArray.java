package medium;
/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		//Base case
		if(nums.length == 1) {
			return nums[0];
		}else if(nums.length == 2) {
			return Math.min(nums[0], nums[1]);
		}
        int start = 1; int end = nums.length-2;
        while(start <= end) {
        		if(nums[start-1] > nums[start]) {
        			//Pivot of rotation found
        			return nums[start];
        		}else if(nums[end] > nums[end+1]) {
        			return nums[end+1];
        		}
        		start++; end--;
        }
        return Math.min(Math.min(nums[0], nums[nums.length-1]), Math.min(nums[start], nums[end]));
    }
}
