package easy;

import java.util.HashSet;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/unique-morse-code-words/description/
 *
 */

public class UniqueMorseCodeWords {	
	public int uniqueMorseRepresentations(String[] words) {
		String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
				".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		HashSet<String> set = new HashSet<String>();
		for(String word: words) {
			StringBuilder temp = new StringBuilder("");
			for(char c: word.toCharArray()) {
				temp.append(morseCodes[c-97]);
			}
			set.add(temp.toString());
		}
		
		return set.size();
    }

}
