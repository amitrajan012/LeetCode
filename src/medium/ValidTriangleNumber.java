package medium;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/valid-triangle-number/description/
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=nums.length-1;i>=0;i--) {
        		int l=0, r=i-1;
        		while(l<r) {
        			if(nums[l]+nums[r] > nums[i]) {
        				res += r-l; //As all the pairs from l till r will have sum greater
        				r--;
        			}else {
        				l++;
        			}
        		}
        }
    		return res;
    }
}
