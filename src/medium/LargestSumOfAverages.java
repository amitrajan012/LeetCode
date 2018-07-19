package medium;
/*
 *https://leetcode.com/problems/largest-sum-of-averages/description/ 
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        //Base case
    		if(K == 0 || A.length == 0) return 0;
    		int len = A.length;
    		//dp[i][j] has largest sum of averages for first i+1 numbers[indexed from 0 to i] and partitioned into j groups
    		//dp[i][j] consists of sum of average of first i-1 groups and average of the ith group.
    		//Let ith group starts from index p+1
    		//Then, dp[i][j] = Max{dp[p][j-1] + [A[p+1] + ... + A[i]] / i-p} for p = 0,1,2, ..., i-1
    		double[][] dp = new double[len][K+1];
    		double[] sum = new double[len+1]; //sum[i] has sum of elements up to index i-1 (or first i numbers)
    		
    		for(int i=1;i<=len;i++) {
    			sum[i] = sum[i-1] + A[i-1];
    			dp[i-1][1] = sum[i] / i;
    		}
    		
    		for(int j=2;j<=K;j++) {
    			for(int i=0;i<len;i++) {
    				double max = Double.MIN_VALUE;
    				for(int p=0;p<i;p++) {
    					double temp = dp[p][j-1] + (sum[i+1] - sum[p+1]) / (i-p);
    					max = Double.max(temp, max);
    				}
    				dp[i][j] = max;
    			}
    		}
    		return dp[len-1][K];
    }
}
