package medium;
/*
 * https://leetcode.com/problems/soup-servings/description/
 */
public class SoupServings {
	double[][] memo = new double[200][200];
    public double soupServings(int N) {
        //Consider 25ml as one serving
    		//For higher values of N, the probability will almost be equal to 1	
    		//First serving is f(a-4, b), second is f(a-3, b-1), third is f(a-2, b-2), fourth is f(a-1, b-3)
    		return N >= 4800 ? 1 : f((N+24)/25, (N+24)/25);
    }

	private double f(int a, int b) {
		if(a<=0 && b<=0) return 0.5;
		if (a <= 0) return 1;
        if (b <= 0) return 0;
        if(memo[a][b] > 0) return memo[a][b];
        memo[a][b] = 0.25 * (f(a-4, b) + f(a-3, b-1) + f(a-2, b-2) + f(a-1, b-3));
		return memo[a][b];
	}
}
