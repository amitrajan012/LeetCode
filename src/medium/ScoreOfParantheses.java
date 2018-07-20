package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/score-of-parentheses/description/
 */
public class ScoreOfParantheses {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        
        for(char c: S.toCharArray()) {
        		if(c == '(') stack.push(new String("("));
        		else if(c == ')') {
        			int score = 0;
        			while(!stack.isEmpty() && !stack.peek().equals("(")) {
        				score += Integer.valueOf(stack.pop());
        			}
        			stack.pop();
        			if (score == 0) stack.push("1");
        			else	 stack.push(Integer.toString(score));
        		}
        }
        
        int res = 0;
        while(!stack.isEmpty()) {
        		res += Integer.valueOf(stack.pop());
        }
        return res;
    }
}
