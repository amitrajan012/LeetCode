package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/increasing-subsequences/description/
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        helper(set, l, 0, nums);
        return new ArrayList(set);
    }

	private void helper(Set<List<Integer>> set, List<Integer> l, int index, int[] nums) {
		if(l.size() >= 2) set.add(new ArrayList(l));
		for(int i=index;i<nums.length;i++) {
			if(l.size() == 0 || l.get(l.size()-1) <= nums[i]) {
				l.add(nums[i]);
				helper(set, l, i+1, nums);
				l.remove(l.size()-1);
			}
		}
		
	}
}
