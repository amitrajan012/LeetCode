/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/non-decreasing-array/description/
 *
 */
public class NonDecreasingArray {
	public boolean checkPossibility(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] > nums[i+1]) {
				int temp = nums[i];
				nums[i] = nums[i+1];
				if(isSorted(nums)) return true;
				
				nums[i] = temp;
				nums[i+1] = nums[i];
				return isSorted(nums);
			}
		}
		
		return true;
	}
	
	private boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
	        if (a[i] > a[i + 1]) {
	            return false;
	        }
	    }
	    return true;
	}
}
