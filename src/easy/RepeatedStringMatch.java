package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 */
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		if(A.contains(B)) return 1; //Base case
		if(!containsSameCharacters(A, B)) return -1;
        StringBuilder sb = new StringBuilder(A);
        int repeat = 1;
        while(sb.length() < 2*B.length()) {
        		if(sb.toString().contains(B)) {
        			return repeat;
        		}else {
        			sb.append(A);
        			repeat++;
        		}
        }
        return sb.toString().contains(B) ? repeat : -1;
    }
	
	private boolean containsSameCharacters(String a, String b) {
        boolean[] hasChars1 = new boolean[26];
        boolean[] hasChars2 = new boolean[26];

        for (int i = 0; i < a.length(); i++) {
            hasChars1[a.charAt(i) - 97] = true;
        }

        for (int i = 0; i < b.length(); i++) {
            hasChars2[b.charAt(i) - 97] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!hasChars1[i] && hasChars2[i]) {
                return false;
            }
        }

        return true;
    }
}
