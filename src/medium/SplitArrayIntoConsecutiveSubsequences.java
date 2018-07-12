package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
    		Map<Integer, Integer> count = new HashMap<>();
    		for(int num: nums) {
    			count.put(num, count.getOrDefault(num, 0)+1);
    		}
    		
    		Map<Integer, Integer> tails = new HashMap<>(); //tails[i] contains number of valid subsequences (longer than 3) whose tail is i
    		
    		for(int num: nums) {
    			if(count.get(num) == 0) continue;
    			count.put(num, count.get(num)-1);
    			if(tails.getOrDefault(num-1, 0) > 0) { //If there exist a vaild subsequence (having 3 numbers) whose tail is num-1, add num to it
    				tails.put(num-1, tails.get(num-1)-1);
    				tails.put(num, tails.getOrDefault(num, 0)+1);
    			}else if(count.get(num+1) != null && count.get(num+2) != null && count.get(num+1) > 0 && count.get(num+2) > 0) { //Form a valid subsequnce by trying to use num, num+1, num+2
    				count.put(num+1, count.get(num+1)-1);
    				count.put(num+2, count.get(num+2)-1);
    				tails.put(num+2, tails.getOrDefault(num+2, 0)+1);
    			}else {
    				return false;
    			}
    		}
    		
    		return true;
    }
}
