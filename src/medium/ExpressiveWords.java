package medium;
/*
 * https://leetcode.com/problems/expressive-words/description/
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String word: words)
        		if(checkExtension(S, word)) res++;
    		return res;
    }

	private boolean checkExtension(String S, String word) {
		int N = S.length(), M = word.length(), i = 0, j = 0;
		while(i < N) {
			if(j < M && S.charAt(i) == word.charAt(j)) j++;
			else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2));
            else if (0 < i && i < N - 1 && S.charAt(i - 1) == S.charAt(i) && S.charAt(i) == S.charAt(i + 1));
            else return false;
			i++;
		}
		return j == M;
	}
}
