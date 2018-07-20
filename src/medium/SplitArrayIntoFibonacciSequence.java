package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
 */
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(S, 0, res);
    		return res;
    }

	private boolean helper(String s, int index, List<Integer> res) {
		if(index == s.length() && res.size() >= 3) return true;
		
		for(int i=index;i<s.length();i++) {
			if(s.charAt(index) == '0' && i > index) break;
			long num = Long.parseLong(s.substring(index, i+1));
			if(num > Integer.MAX_VALUE) break;
			
			int size = res.size();
			if(size >= 2 && num > res.get(size-1) + res.get(size-2)) break; //No need to continue further as we will get numbers which are going to be larger
			if(size <= 1 || num == res.get(size-1) + res.get(size-2)) {
				//Possible part of sequence found
				res.add((int) num);
				if(helper(s, i+1, res)) return true;
				res.remove(res.size()-1);
			}
		}
		return false;
	}
}
