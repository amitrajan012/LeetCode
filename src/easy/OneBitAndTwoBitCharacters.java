package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 *
 */

public class OneBitAndTwoBitCharacters {
	public boolean isOneBitCharacter(int[] bits) {
		if(bits.length == 1) return true;
		int l = bits.length;
		
		//If two 0s in the end: result is always true
		//If ....10 in the end: result depends on count of consecutive 1s ---> if(odd) false if(even) true
		//Start the loop from second last element and break once 0 is encountered
		int countOnes = 0;
		for(int i=l-2; i>=0 && bits[i] !=0; i--) {
			countOnes++;
		}
		return (countOnes%2 == 0) ? true : false;
    }
}
