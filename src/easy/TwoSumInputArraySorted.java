package easy;

public class TwoSumInputArraySorted {
	public int[] twoSum(int[] numbers, int target) {
        //Solution Approach: Scan the array from both the sides as the array is sorted
		//If target is less than the sum of the current two elements increase left pointer
		//If target is greater than the sum of the current two elements decrease right pointer
		
		//Base case
		if(numbers == null || numbers.length == 0) {
			return null;
		}
		
		int i = 0;
		int j = numbers.length - 1;
		
		while(i<j) {
			int sum = numbers[i] + numbers[j];
			if(sum < target) {
				i++;
			}else if(sum > target) {
				j--;
			}else {
				return new int[]{i+1, j+1};
			}
		}
		
		return null;
    }
}
