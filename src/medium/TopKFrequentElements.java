package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
    		Map<Integer, Integer> map = new HashMap<>();
    		for(int n: nums) {
    			map.put(n, map.getOrDefault(n, 0)+1);
    		}
    		
    		TreeMap<Integer, List<Integer>> res = new TreeMap<>(Collections.reverseOrder());
    		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
    			res.computeIfAbsent(entry.getValue(), a -> new ArrayList<>()).add(entry.getKey());
    		}
    		
    		List<Integer> l = new ArrayList<Integer>();
    		while(k > 0) {
    			List<Integer> temp = res.remove(res.firstKey());
    			if(temp.size() <= k) {
    				l.addAll(temp);
    				k -= temp.size();
    			}else {
    				l.addAll(temp.subList(0, k));
    				break;
    			}
    		}
        return l;
    }
}
