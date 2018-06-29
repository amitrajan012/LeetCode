package medium;
/*
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
    public int[] countBits(int num) {
    		int[] res = new int[num+1];
    		res[0] = 0;
    		if(num == 0) return res;
    		res[1] = 1;
    		int pow = 1;
    		for(int i=2;i<=num;i++) {
    			if(i!=0 && (i & (i-1)) == 0) {
    				res[i] = 1;
    				pow = i;
    			}else {
    				res[i] = res[pow]+res[i-pow];
    			}
    		}
    		return res;
    }
}
