package medium;
/*
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if(numRows == 1) {
			return s;
		}
		int N = s.length();
		StringBuilder sb = new StringBuilder();
		for(int row=1;row<=numRows;row++) {
			int start = row-1;
			int i=start;
		
			while(i < N) {
				if(start == 0 || start == numRows-1) {
					sb.append(s.charAt(i));
					i+=(numRows-1)*2;
				}else {
					sb.append(s.charAt(i));
	                i+=(numRows-row)*2; 
	                if(i<s.length()) 
	                {
	                    sb.append(s.charAt(i));
	                    i+=(row-1)*2;
	                }
	                else {
	                		break;
	                }
				}
			}
		}
		return sb.toString();
    }
}
