package medium;
/*
 * https://leetcode.com/problems/single-number-ii/description/
 */
public class SingleNumber2 {
	public int singleNumber(int[] nums) {
		int res = 0;
		//Visualize every number in the form of 32 bit representation
		//For every bit, find the sum for all numbers and find remainder when divided by 3
		//If the bit is set, the set bit belongs to the number which is not repeated
		for(int i=0;i<32;i++) {
			int sumOfBitI = 0;
			for(int j=0;j<nums.length;j++) {
				if(((nums[j] >> i) & 1) == 1){
					sumOfBitI++;
				}
			}
			sumOfBitI %= 3;
			if(sumOfBitI == 1) {
				res |= (sumOfBitI << i);
			}
		}
		return res;
    }
}
