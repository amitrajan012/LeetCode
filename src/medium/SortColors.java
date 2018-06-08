package medium;
/*
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int zeroEnd = 0, oneEnd = 0, twoStart = nums.length-1;
		while(oneEnd <= twoStart) {
			if(nums[oneEnd] == 2) {
				int temp = nums[oneEnd];
				nums[oneEnd] = nums[twoStart];
				nums[twoStart] = temp;
				twoStart--;
			}else if(nums[oneEnd] == 0) {
				int temp = nums[zeroEnd];
				nums[zeroEnd] = nums[oneEnd];
				nums[oneEnd] = temp;
				oneEnd++;
				zeroEnd++;
			}else {
				oneEnd++;
			}
		}
	}
}
