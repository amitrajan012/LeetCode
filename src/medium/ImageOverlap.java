package medium;
/*
 * https://leetcode.com/problems/image-overlap/description/
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
    		int res = 0;
        for(int i = 0; i < A.length; i++) { //A is shifted i to its right and j down
            for(int j = 0; j < A.length; j++) {
                int count = 0;
                for(int m = 0; m < B.length - i; m++) {
                    for(int n = 0; n < B.length - j; n++) {
                        if (i + m < A.length && j + n < A.length && 
                            A[i + m][j + n] == B[m][n] && A[i + m][j + n] == 1) {
                            count++;
                        }
                        
                        res = Math.max(count, res);
                    }
                }
            }
        }
        
        for(int i = 0; i < B.length; i++) { //B is shifted i to its right and j down
            for(int j = 0; j < B.length; j++) {
                int count = 0;
                for(int m = 0; m < A.length - i; m++) {
                    for(int n = 0; n < A.length - j; n++) {
                        if (i + m < B.length && j + n < B.length && 
                            B[i + m][j + n] == A[m][n] && B[i + m][j + n] == 1) {
                            count++;
                        }
                        
                        res = Math.max(count, res);
                    }
                }
            }
        }
    		return res;
    }
}
