package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/subdomain-visit-count/description/
 *
 */
public class SubdomainVisitCount {
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s: cpdomains) {
			int indexSpace = s.indexOf(' ');
			String key = s.substring(indexSpace+1, s.length());
			int value = Integer.valueOf(s.substring(0, indexSpace));
			map.put(key, map.getOrDefault(key, 0)+value);
			StringBuilder sb = new StringBuilder(key);
			while(sb.indexOf(".") != -1) {
				//Dot is there in the remaining string and hence new domain is found
				int indexDot = sb.indexOf(".");
				String k = sb.substring(indexDot+1, sb.length());
				map.put(k, map.getOrDefault(k, 0)+value);
				sb = new StringBuilder(k);
			}
		}
		List<String> res = new ArrayList<String>();
		for(Entry<String, Integer> e: map.entrySet()) {
			StringBuilder temp = new StringBuilder();
			temp.append(e.getValue().toString());
			temp.append(" ");
			temp.append(e.getKey());
			res.add(temp.toString());
		}
		return res;
    }
}
