package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
				//Skip duplicates
				if(i>start && candidates[i] == candidates[i-1]) {
					continue;
				}
				tempList.add(candidates[i]);
				backtrack(list, candidates, remain-candidates[i], tempList, i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
}
