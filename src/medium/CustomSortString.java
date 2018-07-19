package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://leetcode.com/problems/custom-sort-string/description/
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: T.toCharArray()) {
        		map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()) {
        		if(map.containsKey(c)) {
        			char[] repeat = new char[map.get(c)];
        			Arrays.fill(repeat, c);
        			sb.append(repeat);
        			map.remove(c);
        		}
        }
        
        for(Entry<Character, Integer> e: map.entrySet()) {
        		char[] repeat = new char[e.getValue()];
			Arrays.fill(repeat, e.getKey());
			sb.append(repeat);
        }
    		return sb.toString();
    }
}
