package medium;
/*
 * https://leetcode.com/problems/integer-break/description/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
    		if(n == 3) return 2;
    		int[] res = new int[n+1];
    		int ans = 1;
        for(int i=0;i<=n;i++) {
        		res[i] = i;
        }
        
        for(int i=3;i<=n;i++) {
        		for(int j=2;j<i;j++) {
        			res[i] = Math.max(res[i], res[j]*res[i-j]);
        			ans = Math.max(ans, res[i]);
        		}
        }
    		return ans;
    }
}
