package medium;
/*
 * https://leetcode.com/problems/teemo-attacking/description/
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    		int res = 0, cur = 0;
        for(int i=0;i<timeSeries.length;i++) {
        		if(cur <= timeSeries[i]) {
        			res += duration;
        			cur = timeSeries[i] + duration;
        		}
        		else res += (timeSeries[i] + duration - cur);
        }
    		return res;
    }
}
