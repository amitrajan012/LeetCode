package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/find-pivot-index/description/
 *
 */

public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		int sum = 0;
		for(int num: nums)
			sum += num;
		int partialSum = 0;
		for(int i=0;i<nums.length;i++) {
			if(partialSum == sum-partialSum-nums[i]) {
				//Pivot index found
				return i;
			}
            partialSum += nums[i];
		}
		return -1;
	}

}
