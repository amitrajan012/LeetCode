package medium;

import java.util.TreeSet;

/*
 * https://leetcode.com/problems/ugly-number-ii/description/
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
    		TreeSet<Long> set = new TreeSet<Long>();
    		set.add(1l);
        for(int i=1;i<n;i++) {
        		long first = set.pollFirst();
        		set.add(first*2);
        		set.add(first*3);
        		set.add(first*5);
        }
    		return set.pollFirst().intValue();
    }
}
