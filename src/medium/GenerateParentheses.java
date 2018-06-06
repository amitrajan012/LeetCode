package medium;
/*
 * https://leetcode.com/problems/generate-parentheses/description/
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		helper(res, n, n, new char[2*n], 0);
		return res;
    }
	
	public static void helper(List<String> res, int left, int right, char[] str, int count) {
		if(left == 0 && right == 0) {
			//String is found and hence add
			res.add(String.valueOf(str));
		}else {
			if(left > 0) {
				str[count] = '(';
				helper(res, left-1, right, str, count+1);
			}
			if(right > 0 && right > left) {
				str[count] = ')';
				helper(res, left, right-1, str, count+1);
			}
		}
	}
}
