package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/open-the-lock/description/
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        //BFS Solution
    		Queue<String> queue = new LinkedList<>();
    		Set<String> deads = new HashSet<>(Arrays.asList(deadends));
    		Set<String> visited = new HashSet<>();
    		
    		if(deads.contains("0000")) return -1;
    		queue.offer("0000");
    		visited.add("0000");
    		int count = 0;
    		
    		while(!queue.isEmpty()) {
    			int size = queue.size();
    			while(size > 0) {
    				String s = queue.poll();
    				if(deads.contains(s)) {
    					size--;
    					continue;
    				}
    				if(s.equals(target)) return count;
    				StringBuilder sb = new StringBuilder(s);
    				for(int i=0;i<4;i++) {
    					char c = sb.charAt(i);
    					String next = sb.substring(0, i) + (c == '9' ? 0 : c-'0' + 1) + sb.substring(i+1);
    					String previous = sb.substring(0, i) + (c == '0' ? 9 : c-'0' - 1) + sb.substring(i+1);
    					if(!visited.contains(previous) && !deads.contains(previous)) {
    						queue.offer(previous);
    						visited.add(previous);
    					}
    					
    					if(!visited.contains(next) && !deads.contains(next)) {
    						queue.offer(next);
    						visited.add(next);
    					}
    				}
    				size--;
    			}
    			count++;
    		}
    		return -1;
    }
}
