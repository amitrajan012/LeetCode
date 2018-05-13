package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 *
 */

public class LongestWordInDictionary {
	public String longestWord(String[] words) {
        //Sort array by length in descending order, if lengths are equal: sort lexicographically
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length() == b.length())
					return a.compareTo(b); //Sort lexicographically
				else return Integer.compare(b.length(), a.length());
			}
		});
		
		Set<String> set = new HashSet<String>();
		for(String word: words) {
			set.add(word);
		}
		
		for(String word: words) {
			StringBuilder sb = new StringBuilder();
			for(char c: word.toCharArray()) {
				sb.append(c);
				if(!set.contains(sb.toString())) {
					break;
				}
			}
			if(sb.length() == word.length())
				return word;
		}
		return null;
    }
}
