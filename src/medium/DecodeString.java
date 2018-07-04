package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/decode-string/description/
 */
public class DecodeString {
    public String decodeString(String s) {
        //Base case
    		if(s==null || s.length()==0) return  "";
    		String res = "";
    		Stack<Integer> countStack = new Stack<>();
    		Stack<String> resStack = new Stack<>();
    		int idx = 0;
    		while(idx < s.length()) {
    			if(Character.isDigit(s.charAt(idx))) {
    				int count = 0;
    				while(Character.isDigit(s.charAt(idx))) {
    					count = 10*count + (s.charAt(idx) - '0');
    					idx++;
    				}
    				countStack.push(count);
    			}else if(s.charAt(idx) == '[') {
    				resStack.push(res);
    				res = "";
    				idx++;
    			}else if(s.charAt(idx) == ']') {
    				StringBuilder temp = new StringBuilder(resStack.pop());
    				int times = countStack.pop();
    				for(int i=0;i<times;i++) {
    					temp.append(res);
    				}
    				res = temp.toString();
    				idx++;
    			}else {
    				res += s.charAt(idx);
    				idx++;
    			}
    		}
    		
    		return res;
    }
}
