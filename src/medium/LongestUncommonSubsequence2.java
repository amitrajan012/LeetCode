package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/
 */
public class LongestUncommonSubsequence2 {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: strs) {
        		for(String subSeq: getSubseqs(s)) {
        			map.put(subSeq, map.getOrDefault(subSeq, 0)+1);
        		}
        }
        
        int maxLen = -1;
        for(Map.Entry<String, Integer> e: map.entrySet()) {
        		if(e.getValue() == 1) maxLen = Math.max(maxLen, e.getKey().length());
        }
    		return maxLen;
    }
    
    public static Set<String> getSubseqs(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
             res.add("");
             return res;
        }
        Set<String> subRes = getSubseqs(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes) {
        		res.add(s.charAt(0) + seq);
        }
        return res;
    }
}
