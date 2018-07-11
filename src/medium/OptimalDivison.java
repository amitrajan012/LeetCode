package medium;
/*
 * https://leetcode.com/problems/optimal-division/description/
 */
public class OptimalDivison {
    public String optimalDivision(int[] nums) {
        //Numerator needs to be maximized and denominator needs to be minimized
    		//Answer will be: first No. / (./././.)
    		if(nums == null || nums.length == 0) return "";
    		if(nums.length == 1) return "" + nums[0];
    		if(nums.length == 2) return nums[0] + "/" + nums[1];
    		StringBuilder res = new StringBuilder();
    		res.append(nums[0]+"/("+nums[1]);
    		for(int i=2;i<nums.length;i++) {
    			res.append("/");
    			res.append(nums[i]);
    		}
    		res.append(")");
    		return res.toString();
    }
}
