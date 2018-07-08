package medium;
/*
 * https://leetcode.com/problems/diagonal-traverse/description/
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        
        int[] res = new int[m*n];
        int row = 0, col = 0, dir = 1;
        for(int i=0;i<m*n;i++) {
        		res[i] = matrix[row][col];
        		row -= dir; col += dir; //Moving Upward initially
        		
        		if(row >= m) {
        			row = m-1; col += 2; dir = -dir; //Start from the last row and move two columns to the right and reverse the direction as well
        		}
        		if(col >= n) {
        			col = n-1; row += 2; dir = -dir;
        		}
        		if(row < 0) {
        			row = 0; dir = -dir; //Start from the top row and move in the reverse direction
        		}
        		if(col < 0) {
        			col = 0; dir = -dir; //Start from the first column and reverse the direction
        		}
        }
    		return res;
    }
}
