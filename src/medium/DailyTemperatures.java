package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int len = temperatures.length;
        
        for(int i=temperatures.length-2;i>=0;i--) {
        		//If temperature on next day is greater than current day -> Wait time: 1 day
        		if(temperatures[i+1] > temperatures[i]) res[i] = 1;
        		else {
        			int nextIndex = (i+1) + res[i+1];
        			while(nextIndex < len && temperatures[nextIndex] <= temperatures[i]) {
        				if(res[nextIndex] > 0) {
        					nextIndex += res[nextIndex];
        				}else {
        					nextIndex++;
        				}
        			}
        			if(nextIndex >= len) {
        				res[i] = 0;
        			}else {
        				res[i] = nextIndex - i;
        			}
        		}
        }
    		return res;
    }
    
    public int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
