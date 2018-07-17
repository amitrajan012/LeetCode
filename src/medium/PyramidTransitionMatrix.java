package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/pyramid-transition-matrix/description/
 */
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> map = new HashMap<>();
        for(String s: allowed) {
        		String key = s.substring(0, 2);
        		map.putIfAbsent(key, new HashSet<>());
        		map.get(key).add(s.charAt(2));
        }
        
       return helper(map, bottom, "", 1);
    }

	private boolean helper(Map<String, Set<Character>> map, String current, String next, int i) {
		if(current.length() == 1) return true;
		if(next.length()+1 == current.length())
			return helper(map, next, "", 1);
		
		for(Character c: map.getOrDefault(current.subSequence(i-1, i+1), new HashSet<>()))
			if(helper(map, current, next+c, i+1)) return true;
		return false;
	}


}
