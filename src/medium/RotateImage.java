package medium;
/*
 * https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		//Transpose the matrix and flip it
        //First transpose the matrix
		int len = matrix.length;
        for(int i=0;i<len;i++) {
        		for(int j=i+1;j<len;j++) {
        			int temp = matrix[i][j];
        			matrix[i][j] = matrix[j][i];
        			matrix[j][i] = temp;
        		}
        }
        
        //Flip it
        for(int i=0;i<len;i++) {
        		for(int j=0;j<len/2;j++) {
        			int temp=matrix[i][j];
        			matrix[i][j] = matrix[i][len-1-j];
        			matrix[i][len-i-j] = temp;
        		}
        }
    }
}
