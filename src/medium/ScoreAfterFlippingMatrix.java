package medium;
/*
 * https://leetcode.com/problems/score-after-flipping-matrix/description/
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
    		//A[i][0] is worth 1 << (N - 1) points, more than the sum of (A[i][1] + .. + A[i][N-1]).
    		//Hence we need to do a flip such that first element of each row becomes 1 (if they are 0)
    		//Now every A[i][j] is worth 1 << (N - 1 - j) points
    		//For every column, count the current number of 1s. If it is less than the count of 0s, we can make a flip and can earn more points
    	
    		//M : Number of rows, N: Number of columns
    		//res holds the value after the toggle of the first element of each row
    		int M = A.length, N = A[0].length, res = (1 << (N-1)) * M;
    		//Process all the columns [from 1 to N-1]
    		for(int j=1;j<N;j++) {
    			int countOnes = 0;
    			for(int i=0;i<M;i++) {
    				countOnes += A[i][0] == A[i][j] ? 1 : 0; //If the value in current cell is equal to the value in first cell of the row, it will become 1 after the first flip
    			}
    			res += Math.max(countOnes, M-countOnes) * (1 << (N-j-1)); //Flip if the count of 1 is less than count of 0
    		}
    		return res;
    }
}
