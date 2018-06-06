package medium;
/*
 * https://leetcode.com/problems/search-for-a-range/description/
 */
public class SearchForARange {
	int[] res = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
	public int[] searchRange(int[] nums, int target) {
		//Base case
		if(nums == null || nums.length == 0 || nums[0] > target || nums[nums.length-1] < target) {
			return new int[] {-1, -1};
		}
		search(nums, target, 0, nums.length-1);
		if(res[0] == Integer.MAX_VALUE || res[1] == Integer.MIN_VALUE) {
			return new int[] {-1, -1};
		}else {
			return res;
		}
    }

	private void search(int[] nums, int target, int low, int high) {
		if(low < high) {
			return;
		}
		
		int mid = low + (high-low)/2;
		if(nums[mid] == target) {
			//Range spans both side of the middle
			if(res[0] > mid) {
				res[0] = mid;
			}
			if(res[1] < mid) {
				res[1] = mid;
			}
			search(nums, target, low, mid-1);
			search(nums, target, mid+1, high);
		}else if(nums[mid] > target) {
			search(nums, target, low, mid-1);
		}else {
			search(nums, target, mid+1, high);
		}
	}
}
