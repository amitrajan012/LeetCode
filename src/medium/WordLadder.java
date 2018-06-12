package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<String>(wordList);
		//Base case
		if(!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				String cur = queue.remove();
				if(cur.equals(endWord)) {
					return level+1;
				}
				for(String s: getOneEditWords(cur)) {
					if(wordSet.contains(s)) {
						queue.add(s);
						wordSet.remove(s);
					}
				}
			}
			level++;
		}
		return 0;
	}

	private static Set<String> getOneEditWords(String w) {
		Set<String> words = new TreeSet<String>(); //TreeSet used for sorted values
		for(int i=0;i<w.length();i++) {
			char[] wordArray = w.toCharArray();
			//Change the letter to something else
			for(char c = 'a'; c <= 'z'; c++) {
				if(c != wordArray[i]) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}
}
