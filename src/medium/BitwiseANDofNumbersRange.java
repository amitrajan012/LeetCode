package medium;
/*
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
    		int factor = 1; 
    		while(m != n){
    			factor <<= 1;
    			m >>= 1;
    			n >>= 1; 
        }  
        return m * factor	; 
    }
}
