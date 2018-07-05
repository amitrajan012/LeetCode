package medium;
/*
 * https://leetcode.com/problems/circular-array-loop/description/
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        		if(nums[i] == 0) continue; //Node already visited
        		else{
        			int next = i+nums[i];
        			if(next >= nums.length) next %= nums.length;
        			if(next < 0) next += nums.length;
        			
        		}
        }
    		return false;
    }
}
