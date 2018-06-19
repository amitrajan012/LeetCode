package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //Base case
        if(n > 45) {
        		return res;
        }
        helper(res, new ArrayList<Integer>(), n, k, 1);
    		return res;
    }

	private void helper(List<List<Integer>> res, List<Integer> comb, int n, int k, int start) {
		if(comb.size() == k && n == 0) {
			List<Integer> l = new ArrayList<Integer>(comb);
			res.add(l);
			return;
		}
		for(int i=start;i<=9;i++) {
			comb.add(i);
			helper(res, comb, n-i, k, i+1);
			comb.remove(comb.size()-1);
		}
		
	}
}
