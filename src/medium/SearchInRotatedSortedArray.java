package medium;
/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(nums == null) {
			return -1;
		}
		return search(nums, target, 0, nums.length-1);
    }

	private int search(int[] nums, int target, int low, int high) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high-low)/2;
		if(nums[mid] == target) {
			return mid;
		}
		
		if(nums[low] < nums[mid]) {
			//Left part of array is sorted
			if(target >= nums[low] && target < nums[mid]) {
				return search(nums, target, low, mid-1);
			}else {
				return search(nums, target, mid+1, high);
			}
		}else if(nums[low] > nums[mid]){
			//Right part is sorted
			if(target > nums[mid] && target <= nums[high]) {
				return search(nums, target, mid+1, high);
			}else {
				return search(nums, target, low, mid-1);
			}
		}else {
			//No pattern found and hence search in both parts
			int result = search(nums, target, low, mid-1);
			if(result == -1) {
				result = search(nums, target, mid+1, high);
			}
			return result;
		}
	}
}
