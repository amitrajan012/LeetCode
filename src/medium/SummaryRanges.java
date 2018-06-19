package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/summary-ranges/description/
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
    		List<String> res = new ArrayList<String>();
    		if(nums == null || nums.length == 0) {
    			return res;
    		}
    		int start = nums[0], end = nums[0];
    		for(int i=1;i<nums.length;i++) {
    			if(nums[i]-nums[i-1] == 1) {
    				//Continue Range
    				end = nums[i];
    			}else {
    				//Add range
    				if(start == end) {
    					res.add(String.valueOf(start));
    				}else {
    					res.add(String.valueOf(start) + "->" + String.valueOf(end));
    				}
    			
    				start = nums[i];
    				end = nums[i];
    			}
    		}
    		if(start == nums[nums.length-1]) {
    			res.add(String.valueOf(start));
    		}else {
    			res.add(String.valueOf(start) + "->" + String.valueOf(end));
    		}
    		return res;
    }
}
