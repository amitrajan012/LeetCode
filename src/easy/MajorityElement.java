package easy;

public class MajorityElement {
	public int majorityElement(int[] nums) {
        //Solution Approach: Moore's Voting Algorithm
		//In the first pass, find the candidate that can be the majority element
		//Cancel out each occurrence of an element e with all the other elements that are different from e 
		//then e will exist till the end if it is the majority element
		//algorithm loops through each element and maintains a count of a[maj_index], 
		//If next element is same then increments the count, 
		//if next element is not same then decrements the count, 
		//and if the count reaches 0 then changes the maj_index to the current element and sets count to 1
		
		int maj_index = 0;
		int count = 1;
		
		for(int i=1;i<=nums.length-1;i++) {
			if(nums[maj_index] == nums[i]) {
				count++;
			}else {
				count--;
			}
			if(count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		
		//Check whether the candidate is majority element
		count = 0;
		for(int i=0;i<=nums.length-1;i++) {
			if(nums[maj_index] == nums[i]) {
				count++;
			}
		}
		
		if(count > nums.length/2) {
			return nums[maj_index];
		}else {
			return 0;	
		}
    }
}
