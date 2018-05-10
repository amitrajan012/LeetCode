package easy;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++) {
        		if(nums[i] == 0) {
        			//Reset count and update max count
        			if(count > result) {
        				result = count;
        			}
        			count = 0;
        		}else {
        			count++;
        		}
        }
        return count>result ? count : result;
    }
}
