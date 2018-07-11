package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/find-duplicate-file-in-system/description/
 */
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: paths) {
        		String[] S = s.split(" ");
        		String path = S[0];
        		for(int i=1;i<S.length;i++) {
        			String content = S[i].substring(S[i].indexOf('(')+1, S[i].length()-1);
        			List<String> temp;
        			if(map.containsKey(content)) temp = map.get(content);
        			else temp = new ArrayList<>();
        			
        			temp.add(path + "/" + S[i].substring(0, S[i].indexOf('(')));
        			map.put(content, temp);
        		}
        }
        
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: map.entrySet()) {
        		if(e.getValue().size() > 1) res.add(e.getValue());
        }
    		return res;
    }
}
