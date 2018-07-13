package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for(String word: words) {
        		count.put(word, count.getOrDefault(word, 0)+1);
        }
        
        for(Map.Entry<String, Integer> e: count.entrySet()) {
        		System.out.println(e.toString());
        		List<String> temp;
        		if(map.containsKey(e.getValue())) temp = map.get(e.getValue());
        		else temp = new ArrayList<String>();
        		
        		temp.add(e.getKey());
        		map.put(e.getValue(), temp);
        }
        
        List<String> res = new ArrayList<>();
        while(k > 0) {
        		List<String> l = map.pollLastEntry().getValue();
        		if(l.size() <= k) {
        			Collections.sort(l);
        			res.addAll(l);
        			k -= l.size();
        		}else {
        			Collections.sort(l);
        			res.addAll(l.subList(0, k));
        			break;
        		}
        }
        
    		return res;
    }
}
