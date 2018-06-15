package medium;
/*
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		//Base case
		if(grid == null) {
			return 0;
		}
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == '1') {
					//Explore the neighboring grids
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
    }
	
    public void dfs(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == '1') {
            grid[row][col] = '2'; //Mark grid as visited
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
    }
}
