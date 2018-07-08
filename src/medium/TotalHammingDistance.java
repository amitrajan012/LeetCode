package medium;
/*
 * https://leetcode.com/problems/total-hamming-distance/description/
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        if(nums == null || nums.length == 0) return res;
        int mask = 1, N = nums.length;
        for(int i=0;i<32;i++) {
        		int count = 0;
        		for(int num: nums) {
        			if((num & mask) != 0) count++; //Count of 1s at ith bit position
        		}
        		res += (N-count)*count;
                mask <<= 1;
        }
        return res;
    }
}
