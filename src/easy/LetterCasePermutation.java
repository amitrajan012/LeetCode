package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 */

public class LetterCasePermutation {
	List<String> res = new ArrayList<String>();
	public List<String> letterCasePermutation(String S) {
		dfs(S.toCharArray(), 0);
		return res;
	}
	
	private void dfs(char[] s, int i) {
		if(i == s.length) {
			res.add(new String(s));
			return;
		}
		dfs(s, i+1);
		if(!Character.isLetter(s[i])) return;
		s[i] ^= 1 << 5;
		dfs(s, i+1);
		s[i] ^= 1 << 5;
	}
}
