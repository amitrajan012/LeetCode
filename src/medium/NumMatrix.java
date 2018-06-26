package medium;
/*
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
class NumMatrix {
	int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
    		if(matrix.length == 0 || matrix[0].length == 0) return;
        sumMatrix = new int[matrix.length][matrix[0].length];
        sumMatrix[0][0] = matrix[0][0];
        for(int i=1;i<matrix.length;i++) {
        		sumMatrix[i][0] = sumMatrix[i-1][0] + matrix[i][0];
        }
        for(int j=1;j<matrix[0].length;j++) {
    		sumMatrix[0][j] = sumMatrix[0][j-1] + matrix[0][j];
        }
        for(int i=1;i<matrix.length;i++) {
        		for(int j=1;j<matrix.length;j++) {
        			sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i][j];
        		}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2][col2] - (col1 > 0 ? sumMatrix[row2][col1-1] : 0) - (row1 > 0 ? sumMatrix[row1-1][col2] : 0) + 
        		((row1 > 0 && col1 > 0) ? sumMatrix[row1-1][col1-1] : 0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */