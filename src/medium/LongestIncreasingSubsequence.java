package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
    
    public int lengthOfLIS2(int[] nums) {
        if(nums.length ==0)
            return 0;
        
        int[] arr = new int[nums.length];
        for(int i = 0; i<arr.length; i++)
            arr[i] = 1;
        
        
        for(int i = 1;i<nums.length;i++) {
            for(int j = 0; j<i;j++) {
                if(nums[i] > nums[j])
                    arr[i] = Math.max(arr[i], arr[j]+1);
            }
        }
        
        // find maximum from arr
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
}
