package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 */
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        
        int index = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            if(index >= nums.length) index = 0;
            result[index] = nums[i];
            index += 2;
        }
        
        for(int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
