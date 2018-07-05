package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        for(int i=0;i<nums.length;i++) {
                int x = nums[i];
        		if(nums[Math.abs(x)-1] >= 0) nums[Math.abs(x)-1] *= -1;
        		else res.add(Math.abs(x));
        }
    		return res;
    }
}
