package medium;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/find-right-interval/description/
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0;i<intervals.length;i++) {
        		map.put(intervals[i].start, i);
        }
        
        for(int i=0;i<intervals.length;i++) {
        		Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
        		res[i] = (entry==null) ? -1 : entry.getValue();
        }
    		return res;
    }
}
