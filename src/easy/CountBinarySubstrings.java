package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/count-binary-substrings/description/
 *
 */
public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		if(s == null || s.length() == 0 || s.length() == 1) return 0; //Base case
        int countCur = 1, countPre = 0, res = 0;
        for(int i=1;i<s.length();i++) {
        		if(s.charAt(i-1) == s.charAt(i)) {
        			countCur++;
        		}else {
        			countPre = countCur;
        			countCur = 1;
        		}
        		if (countPre >= countCur) res++;
        }
        return res;
    }
}
