package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/basic-calculator-ii/description/
 */
public class BasicCalculator2 {
    public int calculate(String s) {
    		//Base case
    		int len = s.length();
    		if(s == null || len == 0) return 0;
    		s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++) {
        		if(Character.isDigit(s.charAt(i))) {
        			num = num*10+ (s.charAt(i) - '0');
        		}
        		if(!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == len-1) {
        			if(sign == '-') {
        				stack.push(-num);
        			}else if (sign == '+') {
        				stack.push(num);
        			}else if (sign == '*') {
        				stack.push(stack.pop() * num);
        			}else {
        				stack.push(stack.pop() / num);
        			}
        			sign = s.charAt(i);
        			num = 0;
        		}
        }
        int res = 0;
        for(int a : stack) {
        		res += a;
        }
    		return res;
    }
}
