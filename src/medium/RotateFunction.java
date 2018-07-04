package medium;
/*
 * https://leetcode.com/problems/rotate-function/description/
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int res = 0;
        for(int i=0;i<A.length;i++) {
        		sum += A[i];
        		res += (1*A[i]);
        }
        
        int pointer = A.length-1;
        int n = A.length;
        int prev = res;
        while(pointer > 0) {
        		int temp = prev - (n*A[pointer]) + sum;
        		res = Math.max(res, temp);
        		prev = temp;
        		pointer--;
        }
    		return res;
    }
}
