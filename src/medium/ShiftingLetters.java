package medium;
/*
 * https://leetcode.com/problems/shifting-letters/description/
 */
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        long sum = 0;
        for(int i: shifts) sum += i;
        long[] totalShifts = new long[shifts.length];
        for(int i=0;i<shifts.length;i++) {
        		totalShifts[i] = sum;
        		sum -= shifts[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++) {
        		int shift = (int)(totalShifts[i] % 26);
        		char c = (char)(S.charAt(i) + shift);
        		if(c > 'z') c = (char)(c-'z'-1+'a');
        		sb.append(c);
        }
    		return sb.toString();
    }
}
