package medium;
/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 */
public class SearcInRotatedSortedArray2 {
	public boolean search(int[] nums, int target) {
		if(nums == null) {
			return false;
		}
		return search(nums, target, 0, nums.length-1);
    }

	private boolean search(int[] nums, int target, int low, int high) {
		if(low > high) {
			return false;
		}
		int mid = low + (high-low)/2;
		if(nums[mid] == target) {
			return true;
		}
		
		if(nums[low] < nums[mid]) {
			//Left part of array is sorted
			if(target >= nums[low] && target < nums[mid]) {
				return search(nums, target, low, mid-1);
			}else {
				return search(nums, target, mid+1, high);
			}
		}else if(nums[low] > nums[mid]) {
			//Right part is sorted
			if(target > nums[mid] && target <= nums[high]) {
				return search(nums, target, mid+1, high);
			}else {
				return search(nums, target, low, mid-1);
			}
		}else {
			//No pattern found and hence search in both parts
			boolean result = search(nums, target, low, mid-1);
			if(result) {
				result = search(nums, target, mid+1, high);
			}
			return result;
		}
	}
}
