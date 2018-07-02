package medium;

import java.util.Stack;
import java.util.Vector;

/*
 * https://leetcode.com/problems/mini-parser/description/
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        //Base case
    		if(s == null || s.length() == 0) return null;
    		Stack<NestedInteger> stack = new Stack<>();
    		stack.push(new NestedInteger());
    		char sign = '+';
    		Integer num = null;
    		for(int i=0;i<=s.length();i++) {
    			char c = (i == s.length()) ? ',' : s.charAt(i);
    			if(c == '-') {
    				sign = '-';
    			}else if(Character.isDigit(c)) {
    				num = (num == null ? 0: num) * 10 + (c - '0');
    			}else if(c == '[') {
    				stack.push(new NestedInteger());
    			}else {
    				//Either , or ]
    				if(num != null) {
    					stack.peek().add(new NestedInteger(sign=='+' ? num : -num));
    				}
    				num = null;
    				sign = '+';
    				if(c == ']') {
    					NestedInteger cur = stack.pop();
    					stack.peek().add(cur);
    				}
    			}
    		}
    		return stack.pop().getList().get(0);
    }
}

class NestedInteger{

	public NestedInteger(int i) {
		// TODO Auto-generated constructor stub
	}

	public Vector<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public NestedInteger() {
		// TODO Auto-generated constructor stub
	}

	public void add(NestedInteger nestedInteger) {
		// TODO Auto-generated method stub
		
	}
	
}
