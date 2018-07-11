package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/next-greater-element-iii/description/
 */
public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
    		char[] number = (n+"").toCharArray();
    		int index;
    		for(index=number.length-1;index>0;index--) {
    			if(number[index-1] < number[index]) break;
    		}
    		if(index == 0) return -1; //No such number possible
    		
    		//Find smallest digit on the right side of index-1th digit which is greater than number[index-1]
    		int x = number[index-1], smallestIndex = index; //Store the index as they need to be swaped later
    		for(int j=index+1;j<number.length;j++) {
    			if(number[j] > x && number[j] <= number[smallestIndex]) {
    				smallestIndex = j;
    			}
    		}
    		
    		//Swap them
    		char temp = number[smallestIndex];
    		number[smallestIndex] = number[index-1];
    		number[index-1] = temp;
    		
    		//Sort the digits after index-1 in ascending order
    		Arrays.sort(number, index, number.length);
    		long val = Long.parseLong(new String(number));
    		return val <= Integer.MAX_VALUE ? (int) val : -1;
    }
}
