package medium;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/most-profit-assigning-work/description/
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> workers = new TreeMap<>(); //difficulty and count
        int maxDifficulty = Integer.MIN_VALUE;
        for(int w: worker) {
        		maxDifficulty = Math.max(maxDifficulty, w);
        		workers.put(w, workers.getOrDefault(w, 0)+1);
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); //Contains profit as key and minimum value of difficulty (for the same profit) as the value. 
        //Jobs with difficulty greater than max difficulty is discarded
        for(int i=0;i<difficulty.length;i++) {
        		if(difficulty[i] <= maxDifficulty) {
        			map.put(profit[i], Math.min(map.getOrDefault(profit[i], Integer.MAX_VALUE), difficulty[i]));
        		}
        }
        
        int res = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
        		while(workers.ceilingKey(e.getValue())  != null) {
        			res += (e.getKey() * workers.get(workers.ceilingKey(e.getValue())));
        			workers.remove(workers.ceilingKey(e.getValue()));
        		}
        }
        
    		return res;
    }
}
