package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		//Base case
		if(matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}
        int R = matrix.length;
        int C = matrix[0].length;
        //Copy the first row from the remaining rows
        //Copy the last column from the remaining column
        //Copy the last row from the remaining rows
        //copy the first column from the remaining column
        List<Integer> res = new ArrayList<Integer>();
        int rowPointer = 0, columnPointer = 0;
        int i;
        while(rowPointer < R && columnPointer < C) {
        		//Copy the first row from the remaining rows
        		for(i=columnPointer; i<C;i++) {
        			res.add(matrix[rowPointer][i]);
        		}
        		rowPointer++;
        		
        		//Copy the last column from the remaining column
        		for(i=rowPointer;i<R;i++) {
        			res.add(matrix[i][C-1]);
        		}
        		C--;
        		
        		//Copy the last row from the remaining rows
        		if(rowPointer < R) {
        			for(i=C-1;i>=columnPointer;i--) {
            			res.add(matrix[R-1][i]);
            		}
        		}
        		R--;
        		
        		
        		//copy the first column from the remaining column
        		if(columnPointer < C) {
        			for(i=R-1;i>=rowPointer;i--) {
            			res.add(matrix[i][columnPointer]);
            		}
        		}
        		columnPointer++;
        }
		return res;
    }
}
