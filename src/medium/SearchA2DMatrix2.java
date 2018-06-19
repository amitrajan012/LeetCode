package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
    		//Base case
    		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        List<Integer> rowNumbers = new ArrayList<Integer>();
        int rows = matrix.length-1, cols = matrix[0].length-1;
        for(int i=0;i<=rows;i++) {
        		if(matrix[i][0] <= target && target <= matrix[i][cols]) {
        			rowNumbers.add(i);
        		}
        }
        List<Integer> colNumbers = new ArrayList<Integer>();
        for(int i=0;i<=cols;i++) {
        		if(matrix[0][i] <= target && target <= matrix[rows][i]) {
        			colNumbers.add(i);
        		}
        }
        
        for(int i: rowNumbers) {
        		for(int j: colNumbers) {
        			if(matrix[i][j] == target) {
        				return true;
        			}
        		}
        }
    		return false;
    }
    
    public boolean searchMatrix2(int[][] matrix, int target) {
    		//Base case
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int col = matrix[0].length-1, row = 0;
		while(col >=0 && row <= matrix.length-1) {
			if(target == matrix[row][col]) return true;
			else if(target < matrix[row][col]) col--;
			else if(target > matrix[row][col]) row++;
		}
		return false;
    }
}
