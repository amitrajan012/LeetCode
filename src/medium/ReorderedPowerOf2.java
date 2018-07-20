package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/reordered-power-of-2/description/
 */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        String S = Integer.toString(N);
        int mod = (int) Math.pow(10, S.length());
        
        int power = 1;
        while(power/mod == 0) {
        		if(Integer.toString(power).length() == S.length()) {
        			//Check whether two strings are formed by reordering
        			if(check(Integer.toString(power), S)) return true;
        		}
        		power *= 2;
        }
        return false;
    }

	private boolean check(String R, String S) {
		char[] charS = S.toCharArray();
		char[] charR = R.toCharArray();
		Arrays.sort(charR);
		Arrays.sort(charS);
		return charR.toString().equals(charS.toString());
	}
}
