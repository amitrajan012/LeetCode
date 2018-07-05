package medium;
/*
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
        		count[c-'a']++;
        }
        
        int[] res = new int[10];
        if(count['z'-'a'] > 0) {
    			//Count of zero as z is only in zero
    			int temp = count['z'-'a'];
    			res[0] = temp;
    			count['z'-'a'] -= temp;
    			count['e'-'a'] -= temp;
    			count['r'-'a'] -= temp;
            count['o'-'a'] -= temp;
        }
        if(count['w'-'a'] > 0) {
        		//Count of two as w is only in two
        		int temp = count['w'-'a'];
        		res[2] = temp;
        		count['t'-'a'] -= temp;
        		count['w'-'a'] -= temp;
        		count['o'-'a'] -= temp;
        }
        if(count['x'-'a'] > 0) {
    			//Count of six as x is only in six
    			int temp = count['x'-'a'];
    			res[6] = temp;
    			count['s'-'a'] -= temp;
    			count['i'-'a'] -= temp;
    			count['x'-'a'] -= temp;
        }
        if(count['g'-'a'] > 0) {
    			//Count of eight as g is only in eight
    			int temp = count['g'-'a'];
    			res[8] = temp;
    			count['e'-'a'] -= temp;
    			count['i'-'a'] -= temp;
    			count['g'-'a'] -= temp;
    			count['h'-'a'] -= temp;
    			count['t'-'a'] -= temp;
        }
        if(count['h'-'a'] > 0) {
			//Count of three as h is only in three of the remaining digits
			int temp = count['h'-'a'];
			res[3] = temp;
			count['t'-'a'] -= temp;
			count['h'-'a'] -= temp;
			count['r'-'a'] -= temp;
			count['e'-'a'] -= 2*temp;
        }
        if(count['r'-'a'] > 0) {
			//Count of four as r is only in four of the remaining digits
			int temp = count['r'-'a'];
			res[4] = temp;
			count['f'-'a'] -= temp;
			count['o'-'a'] -= temp;
			count['u'-'a'] -= temp;
			count['r'-'a'] -= temp;
        }
        if(count['f'-'a'] > 0) {
			//Count of five as f is only in five of the remaining digits
			int temp = count['f'-'a'];
			res[5] = temp;
			count['f'-'a'] -= temp;
			count['i'-'a'] -= temp;
			count['v'-'a'] -= temp;
			count['e'-'a'] -= temp;
        }
        if(count['o'-'a'] > 0) {
			//Count of one as o is only in one of the remaining digits
			int temp = count['o'-'a'];
			res[1] = temp;
			count['o'-'a'] -= temp;
			count['n'-'a'] -= temp;
			count['e'-'a'] -= temp;
        }
        if(count['s'-'a'] > 0) {
			//Count of seven as s is only in seven of the remaining digits
			int temp = count['s'-'a'];
			res[7] = temp;
			count['s'-'a'] -= temp;
			count['e'-'a'] -= 2*temp;
			count['v'-'a'] -= temp;
			count['n'-'a'] -= temp;
        }
        if(count['i'-'a'] > 0) {
			//Count of nine
			int temp = count['i'-'a'];
			res[9] = temp;
			count['n'-'a'] -= 2*temp;
			count['i'-'a'] -= temp;
			count['e'-'a'] -= temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++) {
        		int temp = i;
        		while(temp > 0) {
        			sb.append((char)(i+'0'));
        			temp--;
        		}
        }
    		return sb.toString();
    }
}
