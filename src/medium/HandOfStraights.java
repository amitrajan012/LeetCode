package medium;

import java.util.TreeMap;

/*
 * https://leetcode.com/problems/hand-of-straights/description/
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i: hand) map.put(i, map.getOrDefault(i, 0)+1);
        
        while(!map.isEmpty()) {
        		int count = W;
        		int current = map.firstKey();
        		map.put(current, map.get(current)-1);
        		if(map.get(current) == 0) map.remove(current);
        		count--;
        		while(count >= 1) {
        			if(!map.containsKey(current+1)) return false;
        			else {
        				map.put(current+1, map.get(current+1)-1);
                		if(map.get(current+1) == 0) map.remove(current+1);
                		count--;
        			}
        		}
        }
    		return true;
    }
}
