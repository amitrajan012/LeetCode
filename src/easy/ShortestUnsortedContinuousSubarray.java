package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 */
public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int start = 0, end = -1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0,j=nums.length-1; j>=0; i++,j--) {
			max = Math.max(max, nums[i]);
			if(nums[i] != max) end = i;
			
			min = Math.min(min, nums[j]);
			if(nums[j] != min) start = j;
		}
		
		return end-start+1;
	}
}
