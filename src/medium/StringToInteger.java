package medium;
/*
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {
	public int myAtoi(String str) {
		str = str.trim();
        if(str == null || str.length() == 0 || str == "") {
            return 0;
        }else if(!(str.charAt(0) == '+' || str.charAt(0) == '-' || Character.isDigit(str.charAt(0)))) {
        		return 0;
        }
        int endIndex = 0;
        boolean indexFound = false;
        for(int i=1;i<str.length();i++) {
        		if(!Character.isDigit(str.charAt(i))) {
        			endIndex = i;
        			indexFound = true;
        			break;
        		}
        }
        if(!indexFound) endIndex = str.length();
        try {
        		if(str.substring(0, endIndex).equals("+")) return 0;
        		else if(str.substring(0, endIndex).equals("-")) return 0;
        		else return Integer.parseInt(str.substring(0, endIndex));
		} catch (Exception e) {
			return (str.charAt(0) == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
    }
}
