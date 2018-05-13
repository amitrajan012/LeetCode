package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/flood-fill/description/
 *
 */

public class FloodFill {
	int MIN_X = 0, MIN_Y = 0, MAX_X = 0, MAX_Y = 0;
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		MAX_X = image.length-1;
		MAX_Y = image[0].length-1;
		fill(image, sr, sc, image[sr][sc], newColor);
		return image;
    }

	private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
		while(sr>=MIN_X && sr<=MAX_X && sc>= MIN_Y && sc<=MAX_Y && image[sr][sc]==oldColor && oldColor!=newColor) {
			image[sr][sc] = newColor;
			fill(image, sr-1, sc, oldColor, newColor);
			fill(image, sr+1, sc, oldColor, newColor);
			fill(image, sr, sc-1, oldColor, newColor);
			fill(image, sr, sc+1, oldColor, newColor);
		}
	}
}
