package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
	}

	private void helper(List<List<Integer>> res, int[] nums, int pos, List<Integer> list) {
		res.add(new ArrayList<Integer>(list));
		for(int i=pos;i<nums.length;i++) {
			if(i != pos && (nums[i] == nums[i-1])) {
				continue;
			}
			list.add(nums[i]);
			helper(res, nums, i+1, list);
			list.remove(list.size()-1);
		}
	}
}
