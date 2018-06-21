package medium;
/*
 * https://leetcode.com/problems/single-number-iii/description/
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        //Get the XOR of two numbers
    		int xor = 0;
    		for(int num: nums) {
    			xor ^= num;
    		}
    		
    		//Find the last set bit
    		xor &= -xor;
    		
    		//The array is divided into two groups: One which has the last set bit set and another which has the last set bit as not set
    		//Two numbers will be in the different groups
    		int[] res = {0, 0};
    		for(int num: nums) {
    			if((num & xor) == 0) {
    				res[0] ^= num;
    			}else {
    				res[1] ^= num;
    			}
    		}
    		return res;
    }
}
