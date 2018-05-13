package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/most-common-word/description/
 *
 */

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.replaceAll("[!?',;.]"," ").toLowerCase().split("\\s+");
		Set<String> set = new HashSet<String>();
		for(String s: banned) {
			set.add(s);
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String w: words) {
			if(!set.contains(w)) {
				map.put(w, map.getOrDefault(w, 0)+1);
			}
		}
		
		int maxCount = Integer.MIN_VALUE;
		String res = null;
		for(Entry<String, Integer> e: map.entrySet()) {
			if(e.getValue() > maxCount) {
				maxCount = e.getValue();
				res = e.getKey();
			}
		}
		return res;
    }
}
