/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/reshape-the-matrix/description/
 *
 */
public class ReshapeTheMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		//Base case: Can't be reshaped
		if(r*c != nums.length*nums[0].length) {
			return nums;
		}
		int[][] result = new int[r][c];
		int m = 0, n = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(n == nums[0].length) {
					m += 1;
					n = 0;
				}
				result[i][j] = nums[m][n];
				n++;
			}
		}
		return result;
    }
}
