package medium;
/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    		//Base case
    		if(nums == null || nums.length < 3) return false;
    		for(int i=0;i<=nums.length-3;i++) {
    			for(int j=i+1;j<=nums.length-2;j++) {
    				if(nums[i] >= nums[j]) continue;
    				for(int k=j+1;k<=nums.length-1;k++) {
    					if(nums[j] < nums[k]) return true;
    				}
    			}
    		}
    		return false;
    }
    
    public boolean increasingTriplet1(int[] nums) {
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=first) first=nums[i];
            else if(nums[i]<=second) second=nums[i];
            else return true;
        }
        return false;
    }
}
