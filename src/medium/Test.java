package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
		String[] nums = new String[] {"3","30","34","5","9"};
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String str1, String str2){
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
			}
		};
			        
		Arrays.sort(nums, comp);
		for(String s: nums) {
			System.out.print(s);
		}
	}
}
