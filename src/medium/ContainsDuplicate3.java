package medium;

import java.util.TreeSet;

/*
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Base case
    		if(nums == null || nums.length == 0 || k <= 0) {
    			return false;
    		}
    		
    		TreeSet<Long> set = new TreeSet<Long>();
    		for(int i=0;i<nums.length;i++) {
    			Long floor = set.floor((long)(nums[i]));
    			Long ceil = set.ceiling((long)(nums[i]));
    			if((floor != null && nums[i]-floor <= t) || (ceil != null && ceil-nums[i] <= t)) {
    				return true;
    			}
    			
    			set.add((long)nums[i]);
    			if(i >= k) {
    				set.remove((long)(nums[i-k]));
    			}
    		}
    		return false;
    }
}
