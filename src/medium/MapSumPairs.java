package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/map-sum-pairs/description/
 */
public class MapSumPairs {

}

class MapSum {

    /** Initialize your data structure here. */
	Map<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry<String, Integer> e: map.entrySet()) {
        		if(e.getKey().length() >= prefix.length() && e.getKey().startsWith(prefix)) {
        			sum += e.getValue();
        		}
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
