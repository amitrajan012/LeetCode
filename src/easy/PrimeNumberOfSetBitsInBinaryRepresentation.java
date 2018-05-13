package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 *
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
	public int countPrimeSetBits(int L, int R) {
		boolean[] map = {false,false,true,true,false,true,false,true,false,false,false,true,false,true,false,false,
				false,true,false,true,false,false,false,true,false,false,false,false,false,true,false};
        
        int count = 0;
        for(int i=L;i<=R;i++) {
        		if(map[Integer.bitCount(i)]) {
        			count++;
        		}
        }
		return count;
    }

}
