package medium;
/*
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) {
        		sum += num;
        }
        if(k <= 0 || sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
    		return helper(nums, visited, 0, k, 0, sum/k);
    }

	private boolean helper(int[] nums, boolean[] visited, int start, int k, int sum, int target) {
		if(k==1) return true;
		if(sum == target) return helper(nums, visited, 0, k-1, 0, target); //As one partition is found
		
		for(int i=start;i<nums.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(helper(nums, visited, i+1, k, sum+nums[i], target)) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
}
