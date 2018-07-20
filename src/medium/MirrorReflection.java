package medium;
/*
 * https://leetcode.com/problems/mirror-reflection/description/
 */
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
    		//Find m and n such that m*p = n*q where m is the number of room extension + 1 and n is number of reflection + 1
    		//If number of light reflection is odd i.e. n is even ==> The meeting corner is on left hand side and hence only possibility is 2
    		//Otherwise the possible corners are 0 and 1 (on the right hand side)
    		// Given the corner is on the right hand side (0 or 1), if room extension is even => m is odd ==> Corner is 1, else corner is 0
    	
    		int m = 1, n = 1;
    		while(m*p != n*q) {
    			n++;
    			m = (n*q)/p;
    		}
    		
    		if(m % 2 == 0 && n % 2 == 1) return 0;
    		if(m % 2 == 1 && n % 2 == 1) return 1;
    		if(m % 2 == 1 && n % 2 == 0) return 2;
    		return -1;
    }
}
