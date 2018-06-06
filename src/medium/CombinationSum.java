package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, candidates, target, new ArrayList<Integer>(), 0);
		return list;
    }

	private void backtrack(List<List<Integer>> list, int[] candidates, int remain, List<Integer> tempList, int start) {
		if(remain < 0) {
			return;
		}else if(remain == 0) {
			list.add(new ArrayList<>(tempList));
		}else {
			for(int i=start;i<candidates.length;i++) {
				tempList.add(candidates[i]);
				backtrack(list, candidates, remain-candidates[i], tempList, i); //Not i+1 as same element can be reused
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
