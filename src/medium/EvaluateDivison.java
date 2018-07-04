package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/evaluate-division/description/
 */
public class EvaluateDivison {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i=0;i<values.length;i++) {
        		map.putIfAbsent(equations[i][0], new HashMap<>());
        		map.putIfAbsent(equations[i][1], new HashMap<>());
        		map.get(equations[i][0]).put(equations[i][1], values[i]);
        		map.get(equations[i][1]).put(equations[i][0], 1/values[i]);
        }
        
        double[] res = new double[queries.length];
        for(int i=0;i<queries.length;i++) {
        		res[i] = helper(queries[i][0], queries[i][1], 1, map, new HashSet<>());
        }
    		return res;
    }

	private double helper(String s, String t, double r, Map<String, Map<String, Double>> map, Set<String> seen) {
		if(!map.containsKey(s) || !seen.add(s)) return -1;
		if(s.equals(t)) return r;
		Map<String, Double> next = map.get(s);
		for(String c: next.keySet()) {
			double result = helper(c, t, r*next.get(c), map, seen);
			if(result != -1) return result;
		}
		return -1;
	}
}
