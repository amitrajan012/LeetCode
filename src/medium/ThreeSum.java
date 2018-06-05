package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length < 3) {
			return Collections.emptyList();
		}
		Arrays.sort(nums);
		//Base case : If all the elements are positive or negative return empty list
		if(nums[0] > 0 || nums[nums.length-1] < 0) {
			return Collections.emptyList();
		}
		
		int l, r;
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<List<Integer>> check = new HashSet<List<Integer>>();
		
		for(int i=0;i<len-2;i++) {
			l = i+1;
			r = len-1;
			while(l<r) {
				int sum = nums[l]+nums[r]+nums[i];
				if(sum == 0) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[l]);
					temp.add(nums[r]);
					if(!check.contains(temp)) {
						check.add(temp);
						res.add(temp);	
					}	
					l++;
					r--;
				}else if(sum < 0) {
					l++;
				}else {
					r--;
				}
			}
		}
		
		return res;
    }
}
