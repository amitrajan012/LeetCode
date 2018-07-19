package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/binary-trees-with-factors/description/
 */
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] A) {
        //dp[i] = Sum(dp[j] * dp[i/j])
    		long res = 0l, mod = (long)(Math.pow(10, 9)) + 7;
    		Arrays.sort(A);
    		Map<Integer, Long> dp = new HashMap<>();
    		
    		for(int i=0;i<A.length;i++) {
    			dp.put(A[i], 1l);
    			for(int j=0;j<i;j++) {
    				if(A[i] % A[j] == 0  && dp.containsKey(A[i]/A[j])) {
    					dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
    				}
    			}
    		}
    		
    		for(long val: dp.values()) res = (res + val) % mod;
    		return (int) res;
    }
}
