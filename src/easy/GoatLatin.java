package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/goat-latin/description/
 *
 */

public class GoatLatin {
	public String toGoatLatin(String S) {
		String[] l = S.split(" ");
		StringBuffer res = new StringBuffer();
		for(int i=0;i<l.length;i++) {
			String temp = l[i];
			StringBuffer sb = new StringBuffer();
			if("AEIOUaeiou".indexOf(temp.charAt(0)) != -1) {
				//First letter is vowel
				sb.append(temp).append("ma").append(new String(new char[i+1]).replace('\0', 'a'));
			}else {
				//Start with consonant
				//Assumption: No word has single consonant
				sb.append(temp.substring(1, temp.length())).append(temp.charAt(0)).append("ma").append(new String(new char[i+1]).replace('\0', 'a'));
			}
			res.append(sb);
			if(i<l.length-1) {
				//Append space
				res.append(" ");
			}
		}
		return res.toString();
    }

}
