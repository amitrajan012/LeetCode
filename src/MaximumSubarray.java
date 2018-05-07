
public class MaximumSubarray {
	public static int maxSubArray(int[] nums){
		
		int size = nums.length;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		
		for(int i=0;i<size;i++){
			temp = temp + nums[i];
			if(max<temp){
				max = temp;
			}
			if(temp < 0){
				temp = 0;
			}
		}
		return max;
	}

}
