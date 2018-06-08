package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0; i<rows.size(); i++){
            set(matrix, rows.get(i), cols.get(i));
        }
    }
    private void set(int[][] arr, int i, int j){
        for(int k=0; k<arr[i].length; k++){
            arr[i][k] = 0;
        }
        for(int k=0; k<arr.length; k++){
            arr[k][j] = 0;
        }
    }
}
