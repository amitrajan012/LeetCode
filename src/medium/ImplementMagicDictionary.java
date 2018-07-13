package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 */
public class ImplementMagicDictionary {

}

class MagicDictionary {

    /** Initialize your data structure here. */
	Map<Integer, Set<String>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict) {
        		Set<String> temp = map.getOrDefault(s.length(), new HashSet<>());
        		temp.add(s);
        		map.put(s.length(), temp);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(map.containsKey(word.length())) {
        		for(String s: map.get(word.length())) {
        			int count = 0;
        			for(int i=0;i<s.length();i++) {
        				if(s.charAt(i) != word.charAt(i)) {
        					count++;
        				}
        				if(count > 1) break;
        			}
        			if(count == 1) return true;
        		}
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */