package medium;
/*
 * https://leetcode.com/problems/shortest-completing-word/description/
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for(char c: licensePlate.toCharArray()) {
        		if(Character.isUpperCase(c) || Character.isLowerCase(c)) {
        			if(Character.isUpperCase(c)) count[c-'A']++;
        			else count[c-'a']++;
        		}
        }
        
        String res = null;
        int len = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++) {
        		String word = words[i];
        		int[] temp = count.clone();
        		for(char c: word.toCharArray()) {
        			temp[Character.toLowerCase(c)-'a']--;
        		}
        		boolean found = true;
        		for(int j=0;j<temp.length;j++) {
        			if(temp[j] > 0) {
        				found = false;
        			}
        		}
        		
        		if(found && word.length() < len) {
        			res = word;
        			len = word.length();
        		}
        }
        
        
    		return res;
    }
}
