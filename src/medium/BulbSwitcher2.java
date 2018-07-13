package medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/bulb-switcher-ii/description/
 */
public class BulbSwitcher2 {
    public int flipLights(int n, int m) {
        //No need to take the entire n, we can take bulbs of count (6 + n mod 6) as state changes for odd, even and for numbers having remainder after dividing vy 3
    		int len = (n > 6) ? 6 + n % 6 : n;
    		StringBuilder sb = new StringBuilder();
    		StringBuilder sb2 = new StringBuilder();
    		StringBuilder sb3 = new StringBuilder();
    		StringBuilder sb4 = new StringBuilder();
    		for(int i=1;i<=len;i++) {
    			sb.append('1');
    			if(i%2==0) {
    				sb2.append('1'); 
    				sb3.append('0'); 
    			}else {
    				sb2.append('0');
    				sb3.append('1'); 
    			}
    			if(i%3==1) {
    				sb4.append('1');
    			}else {
    				sb4.append('0');
    			}
    		}
    		long initialState = Long.valueOf(sb.toString()), state1 = initialState, state2 = Long.valueOf(sb2.toString()), state3 = Long.valueOf(sb3.toString()),
    				state4 = Long.valueOf(sb4.toString());
    		
    		Set<Long> set = new HashSet<>();
    		set.add(initialState);
    		while(m>0) {
    			Set<Long> temp = new HashSet<>();
    			for(long state: set) {
    				temp.add(state ^ state1);
    				temp.add(state ^ state2);
    				temp.add(state ^ state3);
    				temp.add(state ^ state4);
    			}
    			m--;
    			set = temp;
    		}
    		return set.size();
    }
}
