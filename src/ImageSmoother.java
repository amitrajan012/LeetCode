/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/image-smoother/description/
 *
 */
public class ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
		int MIN_X = 0, MIN_Y = 0, MAX_X = M.length-1, MAX_Y = M[0].length-1;
		int[][] result = new int[M.length][M[0].length];
		
		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M[0].length;j++) {
				int startPosX = (i - 1 < MIN_X) ? i : i-1;
				int startPosY = (j - 1 < MIN_Y) ? j : j-1;
				int endPosX =   (i + 1 > MAX_X) ? i : i+1;
				int endPosY =   (j + 1 > MAX_Y) ? j : j+1;
				int sum = 0, count = 0;
				for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
				    for (int colNum=startPosY; colNum<=endPosY; colNum++) {
				    		count++;
				    		sum += M[rowNum][colNum];
				    }
				}
				result[i][j] = sum/count;
			}
			
		}
		return result;
    }
}
