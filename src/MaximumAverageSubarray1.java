/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 */
public class MaximumAverageSubarray1 {
	public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0, temp = 0;
		for(int i=0;i<k;i++) {
        		maxSum += nums[i];
        }
		temp = maxSum;
		for(int i=k;i<nums.length;i++) {
			temp = temp + nums[i] - nums[i-k];
			if(temp > maxSum)
				maxSum = temp;
		}
		return (double)maxSum/k;
    }
}
