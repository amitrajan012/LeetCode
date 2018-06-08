package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutation-sequence/description/
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int[] fact = new int[n+1];
		List<Integer> l = new ArrayList<Integer>();
		fact[0] = 1;
		for(int i=1;i<=n;i++) {
			fact[i] = fact[i-1]*i;
		}
		for(int i=1;i<=n;i++) {
			l.add(i);
		}
		
		k--;
		for(int i=n;i>=1;i--) {
			int j = k/fact[i-1];
			sb.append(l.get(j));
			l.remove(j);
			k -= j*fact[i-1];
		}
		
		return sb.toString();
	}
}
