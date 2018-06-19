package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/majority-element-ii/description/
 */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        int candidate1 = nums[0], candidate2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for(int i=0;i<len;i++) {
        		if(nums[i] == candidate1) count1++;
        		else if(nums[i] == candidate2) count2++;
        		else if(count1 == 0) {
        			candidate1 = nums[i]; count1 = 1;
        		}else if(count2 == 0) {
        			candidate2 = nums[i]; count2 = 1;
        		}else {
        			count1--; count2--;
        		}
        }
        
        count1 = 0; count2 = 0;
        for(int i=0;i<len;i++) {
        		if(nums[i] == candidate1) count1++;
        		else if(nums[i] == candidate2) count2++;
        }
        
        if(count1 > len/3) res.add(candidate1);
        if(count2 > len/3) res.add(candidate2);
    		return res;
    }
}
