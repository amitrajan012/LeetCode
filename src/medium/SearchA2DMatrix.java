package medium;
/*
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		//Base case
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int nRows = matrix.length;
		int nCols = matrix[0].length;
		
		//Base case
		if(target < matrix[0][0] || target > matrix[nRows-1][nCols-1]) {
			return false;
		}
		//Search the appropriate row
		int low = 0, high = nRows-1;
		int mid = -1;
		boolean rowFound = false;
		while(low <= high) {
			mid = low + (high-low)/2;
			if(matrix[mid][0] > target) {
				high = mid-1;
			}else if(matrix[mid][nCols-1] < target) {
				low = mid+1;
			}else {
				rowFound = true;
				break;
			}
		}
		
		if(rowFound) {
			int l = 0, h = nCols-1;
			while(l < h) {
				int m = l+(h-l)/2;
				if(target < matrix[mid][m]) {
					h = m-1;
				}else if(target > matrix[mid][m]) {
					l = m+1;
				}else {
					return true;
				}
			}
		}
		return false;
    }
}
