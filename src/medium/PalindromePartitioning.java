package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        //Base case
    		List<List<String>> res = new ArrayList<List<String>>();
    		if(s == null || s.length() == 0) {
    			return res;
    		}
    		List<String> partition = new ArrayList<String>();
    		addPalindrome(s, res, partition, 0);
    		return res;
    }

	private void addPalindrome(String s, List<List<String>> res, List<String> partition, int start) {
		if(start == s.length()) {
			List<String> temp = new ArrayList<String>(partition);
			res.add(temp);
			return;
		}
		
		for(int i=start+1;i<=s.length();i++) {
			String sub = s.substring(start, i);
			if(isPalindrome(sub)) {
				partition.add(sub);
				addPalindrome(s, res, partition, i);
				partition.remove(partition.size()-1);
			}
		}
	}

	private boolean isPalindrome(String sub) {
		int left = 0, right = sub.length()-1;
		while(left < right) {
			if(sub.charAt(left) != sub.charAt(right)) {
				return false;
			}
			left++; right--;
		}
		return true;
	}
}
