package medium;

import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        //Normalize the times by adding 1 to the end times
    		int[] res = new int[n];
    		int currentFunction = 0, previousTime = 0;
    		Stack<Integer> stack = new Stack<>();
    		
    		for(String log: logs) {
    			String[] split = log.split(":");
    			int func = Integer.parseInt(split[0]);
    			boolean start = split[1].equals("start");
    			int time = Integer.parseInt(split[2]);
    			if(!start) time++;	//Normalize time
    			
    			res[currentFunction] += (time - previousTime);
    			if(start) {
    				stack.push(currentFunction);
    				currentFunction = func;
    			}else {
    				currentFunction = stack.pop();
    			}
    			previousTime = time;
    		}
    		return res;
    }
}
