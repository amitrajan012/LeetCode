package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
    		for(String[] ticket : tickets) {
    			map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
    		}
    		
    		List<String> res = new LinkedList<String>();
    		Stack<String> stack = new Stack<String>();
    		stack.push("JFK");
    		while (!stack.empty()) {
    	        while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
    	            stack.push(map.get(stack.peek()).poll());
    	        res.add(0, stack.pop());
    	    }
    		return res;
    }
}
