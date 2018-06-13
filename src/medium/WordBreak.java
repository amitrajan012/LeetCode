package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		Set<String> setDict = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[len+1];
		dp[0] = true;
		
		for(int i=1;i<=len;i++) { //Go till the length as substring method is used
			for(int j=0;j<i;j++) { 
				if(dp[i]) {
					break; //As previous substrings are already processed
				}
				dp[i] = dp[j] && setDict.contains(s.subSequence(j, i));
			}
		}
		return dp[len];
	}
}
