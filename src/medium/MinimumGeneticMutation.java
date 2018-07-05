package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 */
public class MinimumGeneticMutation {
	
    public int minMutation(String start, String end, String[] bank) {
    		if(start.equals(end)) return 0;
    		Set<String> set = new HashSet<>();
    		for(String s: bank) set.add(s);
        char[] charSet = new char[] {'A', 'C', 'G', 'T'};
        
        int res = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()) {
        		int size = queue.size();
        		while(size-- > 0) {
        			String curr = queue.poll();
        			if(curr.equals(end)) return res;
        			
        			char[] currArray = curr.toCharArray();
        			for(int i=0;i<currArray.length;i++) {
        				char old = currArray[i];
        				for(char c: charSet) {
        					currArray[i] = c;
        					String next = new String(currArray);
        					if(!visited.contains(next) && set.contains(next)) {
        						visited.add(next);
        						queue.offer(next);
        					}
        				}
        				currArray[i] = old;
        			}
        		}
        		res++;
        }
    		return -1;
    }
}
