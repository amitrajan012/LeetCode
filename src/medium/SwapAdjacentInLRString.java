package medium;
/*
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/description/
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
    		int r = 0, l = 0;
        for (int i = 0; i< start.length(); i++){
            if (start.charAt(i) == 'R') r++;
            if (end.charAt(i) == 'L') l++;
            if (start.charAt(i) == 'L') l--;
            if (end.charAt(i) == 'R') r--;

            if ((l<0 || r != 0) && (l != 0 || r<0)) return false;
        }
        
        if (l == 0 && r == 0) return true;
        return false;
    }
}
