package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/remove-k-digits/description/
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        //Base case
    		if(num.length() == k) return "0";
    		
    		Stack<Character> stack = new Stack<>();
    		int index = 0;
    		while(index < num.length()) {
    			while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
    				//Remove the character as previous character value is greater than current
    				stack.pop();
    				k--;
    			}
    			stack.push(num.charAt(index));
    			index++;
    		}
    		
    		//Corner case: 2222
    		while(k > 0) {
    			stack.pop();
    			k--;
    		}
    		
    		StringBuilder sb = new StringBuilder();
    		while(!stack.isEmpty()) {
    			sb.append(stack.pop());
    		}
    		sb.reverse();
    		
    		//Remove 0s from the head
    		while(sb.length() > 1 && sb.charAt(0) == '0') {
    			sb.deleteCharAt(0);
    		}
    		return sb.toString();
    }
}
