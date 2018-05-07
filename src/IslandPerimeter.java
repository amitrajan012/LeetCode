
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
        //For first and last row: for every value of 1 add 1 to perimeter
		int perimeter = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j] == 1) {
					if(i==0 || grid[i-1][j] == 0) {
						perimeter++; // UP edge added to parameter
					}
					if(j==0 || grid[i][j-1] == 0) {
						perimeter++; // LEFT edge added to parameter
					}
					if(i==grid.length-1 || grid[i+1][j] == 0) {
						perimeter++; // DOWN edge added to parameter
					}
					if(j==grid[i].length-1 || grid[i][j+1] == 0) {
						perimeter++; // RIGHT edge added to parameter
					}
				}
			}
		}
		return perimeter;
    }
}
