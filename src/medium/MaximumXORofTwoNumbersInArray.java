package medium;
/*
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 */
public class MaximumXORofTwoNumbersInArray {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int XOR = nums[0] ^ nums[1];
        for(int i=0;i<nums.length;i++) {
        		for(int j=i;j<nums.length;j++) {
        			if((nums[i] ^ nums[j]) > XOR) {
        				XOR = nums[i]^nums[j];
        			}
        		}
        }
    		return XOR;
    }
}
