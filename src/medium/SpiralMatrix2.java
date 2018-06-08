package medium;
/*
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 */
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		
		int rowPointer = 0, columnPointer = 0;
		int i;
		int num = 1;
		int C = n; int R = n;
		while(rowPointer < n && columnPointer < n) {
    			for(i=columnPointer; i<C;i++) {
    				matrix[rowPointer][i] = num;
    				num++;
    			}
    		rowPointer++;
    		
    		//Copy the last column from the remaining column
    		for(i=rowPointer;i<R;i++) {
    			matrix[i][C-1] = num;
    			num++;
    		}
    		C--;
    		
    		//Copy the last row from the remaining rows
    		if(rowPointer < R) {
    			for(i=C-1;i>=columnPointer;i--) {
    				matrix[R-1][i] = num;
    				num++;
        		}
    		}
    		R--;
    		
    		
    		//copy the first column from the remaining column
    		if(columnPointer < C) {
    			for(i=R-1;i>=rowPointer;i--) {
    				matrix[i][columnPointer] = num;
    				num++;
        		}
    		}
    		columnPointer++;
    }
		return matrix;
    }
}
