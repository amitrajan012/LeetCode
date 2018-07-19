package medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
    		//Time limit exceeds
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<S.length();i++) {
        		Queue<Integer> temp;
        		if(map.containsKey(S.charAt(i))) {
        			temp = map.get(S.charAt(i));
        		}else {
        			temp = new LinkedList<>();
        		}
        		temp.add(i);
        		map.put(S.charAt(i), temp);
        }
        
        int res = 0;
        for(String word: words) {
        		Map<Character, Queue<Integer>> temp = new HashMap<>();
        		for(Map.Entry<Character, Queue<Integer>> e: map.entrySet()) {
        			temp.put(e.getKey(), new LinkedList<Integer>(e.getValue()));
        		}
        		int prevoiusIndex = -1;
        		boolean isSubsequence = true;
        		for(char c: word.toCharArray()) {
        			if(!temp.containsKey(c)) {
        				isSubsequence = false;
        				break; //Not a subsequence
        			}else {
        				Queue<Integer> q = temp.get(c);
        				while(!q.isEmpty() && q.peek() < prevoiusIndex) {
        					q.poll();
        				}
        				if(q.peek() != null) {
        					prevoiusIndex = q.poll();
        				}else {
        					isSubsequence = false;
            				break; //Not a subsequence
        				}
        				temp.put(c, q);
        			}
        		}
        		if(isSubsequence) res++;
        }
    		return res;
    }
    
    public int numMatchingSubseq1(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}
