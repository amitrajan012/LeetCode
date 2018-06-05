package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int l,r;
		int len = nums.length;
		int closestThreeSum = Integer.MAX_VALUE;
		int minDif = Integer.MAX_VALUE;
		boolean foundTarget = false;
		for(int i=0;i<len-2;i++) {
			l=i+1;
			r=len-1;
			while(l<r) {
				int twoSum = nums[l]+nums[r];
				if(twoSum == target-nums[i]) {
					closestThreeSum = target;
                    foundTarget = true;
                    break;
				}
				int possibleClosestTarget = twoSum + nums[i];
				int distanceFromTarget = Math.abs(target-possibleClosestTarget);
				if(distanceFromTarget < minDif) {
					minDif = distanceFromTarget;
					closestThreeSum = possibleClosestTarget;
				}
				if(twoSum < target-nums[i]) {
					l++;
				}else {
					r--;
				}
			}
			
			if(foundTarget) {
				break;
			}
		}
		
		return closestThreeSum;
    }
}
