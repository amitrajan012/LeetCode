package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/range-addition-ii/description/
 *
 */
public class RangeAddition2 {
	public int maxCount(int m, int n, int[][] ops) {
		int a=m, b=n;
        for(int i=0;i<ops.length;i++) {
        		a = Math.min(a, ops[i][0]);
        		b = Math.min(b, ops[i][1]);
        }
		return a*b;
    }
}
