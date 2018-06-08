package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        //Base case
        if(path == null || path.length() == 0 || path.charAt(0) != '/') {
        		return "";
        }
        
        String[] paths = path.split("/");
        for(String s: paths) {
        		if(!s.equals("")) {
        			if(s.equals("..")) {
        				if(!stack.isEmpty()) {
        					stack.pop();
        				}
        			}else if(s.equals(".")) {
        				//Do nothing
        			}else {
        				stack.push(s);
        			}
        		}
        }
        if(stack.isEmpty()) {
        		return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        		sb.insert(0, stack.pop());
        		sb.insert(0, '/');
        }
		return sb.toString();
    }
}
