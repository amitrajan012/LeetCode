package medium;

import java.util.Arrays;
import java.util.Stack;

/*
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<2*n;i++) {
        		int num = nums[i%n];
        		while(!stack.isEmpty() && nums[stack.peek()] < num) {
        			res[stack.pop()] = num;
        		}
        		if(i < n) stack.push(i);
        }
    		return res;
    }
}
