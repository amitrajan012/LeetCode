package medium;
/*
 * https://leetcode.com/problems/super-pow/description/
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        a %= 1337;
        if(a == 0) return 0;
        int p=0;
        for(int i:b) {
        		p = (p*10+i)%1140; //1140 is Phi(1337) Euler's Totient Function
        }
        if(p == 0) p += 1140;
    		return power(a, p, 1337);
    }

	private int power(int a, int p, int mod) {
		a %= mod;
		int ret = 1;
		while(p != 0) {
			if((p&1) != 0) {
				ret = ret*a % mod; //Need to take a into account
			}
			a = a*a % mod;
			p >>= 1;
		}
		return ret;
	}
}
