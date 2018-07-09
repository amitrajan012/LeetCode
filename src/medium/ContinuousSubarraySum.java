package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        //dp[i][j] represents the sum of subarray starting at index i and ending at index j
    		//dp[i][j] = dp[i+1][j-1] + nums[i] + nums[j]
    		//dp[i][i] = nums[i]
    		
    		//Can save the things in one dimensional array as well
    		int[] dp = new int[nums.length]; //Save the sum of array upto index i
    		dp[0] = nums[0];
    		for(int i=1;i<nums.length;i++) {
    			dp[i] = dp[i-1]+nums[i];
    			if(k == 0 && dp[i] == 0) return true;
    			if(k != 0 && dp[i] % k == 0) return true;
    		}
    		
    		for(int i=1;i<nums.length;i++) {
    			for(int j=i+1;j<nums.length;j++) {
    				if(k == 0 && (dp[j]-dp[i-1]) == 0) return true;
        			if(k != 0 && (dp[j]-dp[i-1]) % k == 0) return true;
    			}
    		}
    		return false;
    }
    
    //We iterate through the input array exactly once, keeping track of the running sum mod k of the elements in the process. 
    //If we find that a running sum value at index j has been previously seen before in some earlier index i in the array, 
    //then we know that the sub-array (i,j] contains a desired sum.
    
    public boolean checkSubarraySum1(int[] nums, int k) {
    	 	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	 	map.put(0, -1);
    	 	int sum = 0;
    	 	for(int i=0;i<nums.length;i++) {
    	 		sum += nums[i];
    	 		if(k != 0) sum %= k;
    	 		Integer prev = map.get(sum);
    	 		if(prev != null) {
    	 			if(i-prev > 1) return true;
    	 		}
    	 		else map.put(sum, i);
    	 	}
    	 	return false;
    }
    
}
