package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/jewels-and-stones/description/
 *
 */

public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		boolean[] jewels = new boolean[58];
		for(char c: J.toCharArray()) {
			jewels[(int)c - 65] = true;
		}
		
		int count = 0;
		for(char c: S.toCharArray()) {
			if(jewels[(int)c - 65])
				count++;
		}
		return count;
    }

}
