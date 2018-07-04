package medium;
/*
 * https://leetcode.com/problems/is-subsequence/description/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
    		//Base case
    		if(s == null || s.length() == 0) return true;
        int i=0;
        int pointer = 0;
        while(i < t.length()) {
        		if(t.charAt(i) == s.charAt(pointer)) {
        			pointer++;
        			if(pointer == s.length()) return true;
        		}
        		i++;
        }
    		return false;
    }
}
