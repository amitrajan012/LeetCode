package medium;
/*
 * https://leetcode.com/problems/powx-n/description/
 */
public class PowX_N {
	public double myPow(double x, int n) {
        double res = 1.0;
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        
        while(N>0) {
        		if(N%2 == 1) {
        			res *= x;
        		}
        		N /=2;
        		x *= x;
        }
        return res;
    }
}
