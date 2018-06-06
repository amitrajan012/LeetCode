package medium;
/*
 * https://leetcode.com/problems/next-permutation/description/
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int firstIndex = -1;
		for(int i=nums.length-1;i>=1;i--) {
			if(nums[i] > nums[i-1]) {
				firstIndex = i-1;
				break;
			}
		}
		
		if(firstIndex == -1) {
			//reverse the array 
			reverse(nums, 0, nums.length-1);
		}else {
			int nextIndex = -1;
			for(int i=firstIndex+1;i<nums.length;i++) {
				if(nums[i] <= nums[firstIndex]) {
					nextIndex = i-1;
					break;
				}else{
                    nextIndex = i;
                }
			}
			//Swap the numbers
			int temp = nums[nextIndex];
			nums[nextIndex] = nums[firstIndex];
			nums[firstIndex] = temp;
			reverse(nums, firstIndex+1, nums.length-1);
		}
		
		
    }

	private void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
            start++;
            end--;
		}
	}
}
