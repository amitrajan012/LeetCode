package medium;
/*
 * https://leetcode.com/problems/consecutive-numbers-sum/description/
 */
public class ConsecutiveNumberSums {
    public int consecutiveNumbersSum(int N) {
        int res = 1;
        for(int k=2;k<Math.sqrt(2*N);k++) {
        		if((N-(k*(k-1))/2) % k == 0) res++;
        }
    		return res;
    }
}
