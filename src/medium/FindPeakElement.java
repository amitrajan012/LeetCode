package medium;
/*
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		return helper(nums, 0, nums.length-1);
    }

	private int helper(int[] nums, int low, int high) {
		if(low == high) {
			return low;
		}else if(low+1 == high) {
			if(nums[low] > nums[high]) return low;
			else return high;
		}else {
			int mid = low + (high-low)/2;
			if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
				return mid;
			}else if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
				//The left side must have a peak
				return helper(nums, low, mid-1);
			}else {
				return helper(nums, mid+1, high);
			}
		
		}
	}
	
	 public int findPeakElement2(int[] nums) {
	        if(nums.length == 1) {
	        		return 0;
	        }
	        for(int i = 0; i < nums.length - 1; i++){
	            if(nums[i] > nums[i + 1])
	                return i;
	        }
	        return nums.length - 1;
	 }
}
