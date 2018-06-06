package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String s: strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);
			List<String> t = map.getOrDefault(sorted, new ArrayList<String>());
			t.add(s);
			map.put(sorted, t);
		}
		
		for(List<String> a: map.values()) {
			list.add(a);
		}
		return list;
    }
}
