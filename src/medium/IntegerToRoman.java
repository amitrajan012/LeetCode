package medium;
/*
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV", "I"};
        int[] nums = {1000, 900, 500, 400,  100,  90,   50,  40,  10,  9,   5 , 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++) {
        		int count = num/nums[i];
        		while(count > 0) {
        			sb.append(roman[i]);
        			count--;
        		}
        		num %= nums[i];
        }
        return sb.toString();
	}
}
