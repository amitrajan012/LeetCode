package medium;

import java.util.Stack;

/*
 * https://leetcode.com/problems/asteroid-collision/description/
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
    		Stack<Integer> stack = new Stack<>();
    		for(int i=0;i<asteroids.length;i++) {
    			if(stack.isEmpty() || asteroids[i] > 0) {
    				stack.push(asteroids[i]);
    				continue;
    			}
    			
    			while(true) {
    				int prev = stack.peek();
    				if(prev < 0) {
    					//Previous negative and current negative and hence no collision
    					stack.push(asteroids[i]);
    					break;
    				}
    				if(prev == -asteroids[i]) {
    					//Previous positive and current negative and have same size: Collision will happen and both will destroy
    					stack.pop();
    					break;
    				}
    				if(prev > -asteroids[i]) {
    					//Previous positive and current negative and previous has bigger size: Collision will happen and current will destroy
    					break;
    				}
    				//Last case
    				//Previous positive and current negative and current has bigger size: Collision will happen and previous will destroy
    				stack.pop(); //Check for further collision
    				if(stack.isEmpty()) {
    					stack.push(asteroids[i]);
    					break;
    				}
    			}
    		}
    		
    		int[] res = new int[stack.size()];
    		for(int i=stack.size()-1;i>=0;i--) {
    			res[i] = stack.pop();
    		}
    		
    		return res;
    }
}
