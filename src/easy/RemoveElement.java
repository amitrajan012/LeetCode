package easy;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while(i<n){
			if(nums[i] == val){
				//Replace element to be discarded with the last element
				//Reduce the size of the array by 1 as the last element needs not to be checked
				nums[i] = nums[n-1];
				n--;
			}else{
				i++;
			}
		}
		return n;
	}
}
