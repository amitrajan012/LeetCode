/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/detect-capital/description/
 */
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		if(word.length()==1) 
			return true;
		if(Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
			return false;
		}
		boolean upperCase = false;
		if(Character.isUpperCase(word.charAt(0)))
			upperCase = true; 
		if(Character.isLowerCase(word.charAt(1)))
			upperCase = false;
        for(int i=2;i<word.length();i++) {
        		if(upperCase && Character.isLowerCase(word.charAt(i)))
        			return false;
        		else if(!upperCase && Character.isUpperCase(word.charAt(i)))
        			return false;
        }
		return true;
    }
}
