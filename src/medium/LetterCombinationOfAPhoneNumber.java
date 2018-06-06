package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> options = new ArrayList<>();
        List<String> result = new ArrayList<>();
        options.add("abc");
        options.add("def");
        options.add("ghi");
        options.add("jkl");
        options.add("mno");
        options.add("pqrs");
        options.add("tuv");
        options.add("wxyz");
        char[] digit = digits.toCharArray();
		
        for(int i=0;i<digit.length;i++) {
        		int index = digit[i] - '0' - 2;
        		String next = options.get(index);
        		result = cartesianProd(result, next);
        }
		return result;
    }

	private List<String> cartesianProd(List<String> initial, String next) {
		List<String> result = new ArrayList<>();
		if (initial.size() == 0){
            for (int i=0;i<next.length();i++){
                result.add(String.valueOf(next.charAt(i)));
            }
            return result;
        }
        for (int i = 0;i<initial.size();i++){
            for (int j=0;j<next.length();j++){
                result.add(initial.get(i) + String.valueOf(next.charAt(j)));
            }
        }
        return result;
	}
}
