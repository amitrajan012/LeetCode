package medium;
/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		//Base case
		if(s == null || s.length() == 0) {
			return 0;
		}
		int max = 1;
		int startIndex = 0, endIndex = 0;
		int[] charFound = new int[127];
		charFound[s.charAt(0)] = 1;
		for(int i=1;i<s.length();i++) {
			char c = s.charAt(i);
			if(charFound[c] == 1) {
				//Character is repeated
				//Reset the value of max (if new max is found)
				if(endIndex-startIndex+1 > max) {
					max = endIndex - startIndex+1;
				}
				//Reset the value in charFound Array
				for(int j=startIndex;j<=endIndex;j++) {
					if(s.charAt(j) == c) {
						startIndex = j+1;
						break;
					}else {
						charFound[s.charAt(j)] = 0;
					}
				}
				endIndex++;
			}else {
                charFound[c] = 1;
				endIndex = i;
			}
		}
		
		return max > (endIndex-startIndex+1) ? max : (endIndex-startIndex+1);
    }
}
