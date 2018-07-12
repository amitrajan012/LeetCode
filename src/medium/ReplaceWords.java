package medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/replace-words/description/
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
    		if(sentence == null || sentence.length() == 0) return "";
        Collections.sort(dict, new Comparator<String>(){
			@Override
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
        
		});
        
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s: split) {
        		boolean rootFound = false;
        		for(String d: dict) {
        			if(s.length() >= d.length() && s.substring(0, d.length()).equals(d)) {
        				sb.append(d + " ");
        				rootFound = true;
        				break;
        			}
        		}
        		if(!rootFound) {
    				sb.append(s + " ");
    			}
        }
        
    		return sb.toString().trim();
    }
}
