package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
        		if(map.containsKey(c)) map.put(c, map.get(c)+1);
        		else map.put(c, 1);
        }
        
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> a, Entry<Character, Integer> b) {
				return b.getValue()-a.getValue();
			}
		});
        
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        		Map.Entry<Character, Integer> e = pq.poll();
        		for(int i=1;i<=e.getValue();i++) {
        			sb.append(e.getKey());
        		}
        }
    		return sb.toString();
    }
}
