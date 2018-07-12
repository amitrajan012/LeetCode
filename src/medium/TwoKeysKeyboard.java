package medium;
/*
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class TwoKeysKeyboard {
	int res = Integer.MAX_VALUE;
    public int minSteps(int n) {
        helper(n, new StringBuilder("A"), new StringBuilder(), 0);
    		return res;
    }
	private void helper(int n, StringBuilder content, StringBuilder copiedCharacters, int steps) {
		if(content.length() == n) {
			res = Math.min(res, steps);
		}
		
		while(content.length()+copiedCharacters.length() <= n) {
			//Case 1: Paste previously copied content
			StringBuilder temp = new StringBuilder(content);
			content.append(copiedCharacters);
			helper(n, content, copiedCharacters, steps+1);
			steps--;
			//Case 2: Copy Current content
			helper(n, temp, temp, steps+1);
		}
		return;
	}
	
    public int minSteps1(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
                
            }
        }
        return dp[n];
    }
}
