package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/masking-personal-information/description/
 */
public class MaskingPersonalInformation {
    public String maskPII(String S) {
    		StringBuilder sb = new StringBuilder();
        if(S.indexOf('@') != -1) {
        		//Email address
        		sb.append(Character.toLowerCase(S.charAt(0)));
        		sb.append("*****");
        		sb.append(Character.toLowerCase(S.charAt(S.indexOf('@')-1)));
        		sb.append("@");
        		sb.append(S.substring(S.indexOf('@')+1, S.indexOf('.')).toLowerCase());
        		sb.append(".");
        		sb.append(S.substring(S.indexOf('.')+1, S.length()).toLowerCase());
        }else {
        		S = S.replaceAll("\\(|\\)|-| |\\+", "");
        		if(S.length() > 10) {
        			sb.append("+");
        			char[] temp = new char[S.length()-10];
        			Arrays.fill(temp, '*');
        			sb.append(temp);
        			sb.append("-");
        		}
        		sb.append("***-***-");
        		sb.append(S.substring(S.length()-4, S.length()));
        }
    		return sb.toString();
    }
}
