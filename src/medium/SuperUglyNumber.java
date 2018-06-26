package medium;

import java.util.TreeSet;

/*
 * https://leetcode.com/problems/super-ugly-number/description/
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
    		//Time limit exceeds
		TreeSet<Long> set = new TreeSet<Long>();
		set.add(1l);
		for(int i=1;i<n;i++) {
    			long first = set.pollFirst();
    			for(int j=0;j<primes.length;j++) {
    				set.add(first*primes[j]);
    			}
		}
		return set.pollFirst().intValue();
    }
    
    public int nthSuperUglyNumberI(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
            		ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }
            
            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }
}
