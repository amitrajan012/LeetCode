package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 */
public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0; //Base case
		int max = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) {
					max = Math.max(max, findArea(grid, i, j));
				}
			}
		}
		return max;
    }

	private int findArea(int[][] grid, int i, int j) {
		if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] != 1) {
			return 0;
		}
		grid[i][j] = -1; //Mark as counted
		return 1 + findArea(grid, i-1, j) + findArea(grid, i+1, j) + findArea(grid, i, j-1) + findArea(grid, i, j+1);
	}
}
