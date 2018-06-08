package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/combinations/description/
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		//Base case
		if(k <=0 || n <= 0) {
			return new ArrayList<>();
		}
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       combine(res, new ArrayList<Integer>(), 1, n, k);
       return res;
    }

	private void combine(List<List<Integer>> res, ArrayList<Integer> l, int start, int n, int k) {
		if(k==0) {
			res.add(new ArrayList<Integer>(l));
			return;
		}
		for(int i=start;i<=n-(k-1);i++) {
			l.add(i);
			combine(res, l, i+1, n, k-1);
			l.remove(l.size()-1);
		}
	}
}
