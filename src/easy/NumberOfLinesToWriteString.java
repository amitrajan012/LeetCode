package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
 *
 */

public class NumberOfLinesToWriteString {
	public int[] numberOfLines(int[] widths, String S) {
		int[] res = new int[2];
		if(S.length() == 0) return res;
		int lines = 1, len = 0; //Line 1 has started
		for(char c: S.toCharArray()) {
			if(100-len >= widths[c-97]) {
				//Space left in current line
				len += widths[c-97];
			}else {
				//Line is full
				lines++;
				len = widths[c-97];
			}
		}
		res[0] = lines; res[1] = len;
		return res;
    }

}
