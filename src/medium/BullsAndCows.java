package medium;

/*
 * https://leetcode.com/problems/bulls-and-cows/description/
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
    		int[] c = new int[10];
    		int bulls = 0, cows = 0;
    		for(int i=0;i<secret.length();i++) {
    			int s = secret.charAt(i) - '0';
    			int g = guess.charAt(i) - '0';
    			if(s == g) {
    				bulls++;
    			}else {
    				if(c[s]++ < 0) cows++;
    				if(c[g]-- > 0) cows++;
    			}
    		}
    		
    		return bulls + "A" + cows + "B";
    }
}
