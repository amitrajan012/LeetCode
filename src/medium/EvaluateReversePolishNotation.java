package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		//Base case
		if(tokens == null || tokens.length == 0) {
			return 0;
		}else if(tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(Integer.parseInt(tokens[0]));
		stack.push(Integer.parseInt(tokens[1]));
		for(int i=2;i<tokens.length;i++) {
			String s = tokens[i];
			if(s.equals(new String("/")) || s.equals(new String("*")) || s.equals(new String("+")) || s.equals(new String("-"))) {
				int b = stack.pop();
				int a = stack.pop();
				if(s.equals(new String("/"))) {
					stack.push(a/b);
				}else if(s.equals(new String("*"))) {
					stack.push(a*b);
				}else if(s.equals(new String("+"))) {
					stack.push(a+b);
				}else if(s.equals(new String("-"))) {
					stack.push(a-b);
				}
			}else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
    }
}
