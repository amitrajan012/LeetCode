package medium;
/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
		//Base case
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int curElem = nums[0], count = 1;
		int pointer = 1;
        for(int i=1;i<nums.length;i++) {
        		if(nums[i] == curElem) {
        			if(count < 2) {
        				nums[pointer] = nums[i];
        				pointer++;
        				count++;
        			}
        		}else {
        			curElem = nums[i];
        			count = 1;
        			nums[pointer] = nums[i];
        			pointer++;
        		}
        }
		return pointer;
    }
}
