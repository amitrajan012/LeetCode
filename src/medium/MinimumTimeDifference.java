package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/minimum-time-difference/description/
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> temp = new ArrayList<>();
        for(String s: timePoints) {
        		int hour = Integer.valueOf(s.substring(0, 2));
        		int min = Integer.valueOf(s.substring(3, 5));
        		temp.add(hour*60+min);
        }
        
        Collections.sort(temp);
        int res = 1440 - (temp.get(temp.size()-1) - temp.get(0));
        for(int i=1;i<temp.size();i++) {
        		res = Math.min(res, temp.get(i) - temp.get(i-1));
        }
    		return res;
    }
}
