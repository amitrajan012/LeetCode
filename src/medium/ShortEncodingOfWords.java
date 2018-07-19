package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/short-encoding-of-words/description/
 */
public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for(String w: words) {
        		for(int i=1;i<w.length();i++) {
        			set.remove(w.substring(i)); //Current word is added and all the substrings of the corresponding string is removed from the set as they are covered
        		}
        }
        
        int res = 0;
        for(String s: set)
        		res += (s.length()+1); //1 is for the #
    		return res;
    }
}
