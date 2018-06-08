package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		//Base case
		if(nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<>());
		subsets(res, new ArrayList<Integer>(), nums, 0);
		return res;
    }

	private void subsets(List<List<Integer>> res, ArrayList<Integer> l, int[] nums, int start) {
		if(start == nums.length) {
			res.add(l);
			return;
		}
		subsets(res, l, nums, start+1);
		ArrayList<Integer> list = new ArrayList<>(l);
		l.add(nums[start]);
		subsets(res, l, nums, start+1);
	}
	
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<>());
		for(int n: nums) {
			int size = res.size();
			for(int i=0;i<size;i++) {
				List<Integer> s = new ArrayList<>(res.get(i));
				s.add(n);
				res.add(s);
			}
		}
		return res;
    }
}
