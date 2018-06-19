package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 */
public class DifferentWaysToAddParantheses {
	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<input.length();i++) {
        		if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
        			String part1 = input.substring(0, i);
        			String part2 = input.substring(i+1);
        			List<Integer> res1 = diffWaysToCompute(part1);
        			List<Integer> res2 = diffWaysToCompute(part2);
        			for(Integer x: res1) {
        				for(Integer y: res2) {
        					if(input.charAt(i) == '+') res.add(x+y);
        					else if(input.charAt(i) == '-') res.add(x-y);
        					else res.add(x*y);
        				}
        			}
        		}
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
}
