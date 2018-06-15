package medium;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/problems/largest-number/description/
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
        		numsString[i] = Integer.toString(nums[i]);
        }
        
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String str1, String str2){
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
			}
		};
			        
		Arrays.sort(numsString, comp);
		//Edge case
		if(numsString[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for(String s: numsString) {
			sb.append(s);
		}
		return sb.toString();
    }
}
