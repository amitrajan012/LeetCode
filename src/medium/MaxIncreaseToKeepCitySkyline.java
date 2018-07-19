package medium;
/*
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
    		//Base case
    		if(grid == null || grid.length <= 1 || grid[0].length <= 1) return 0;
        int[] top = new int[grid[0].length];
        int[] side = new int[grid.length];
        
        for(int i=0;i<grid.length;i++) {
        		for(int j=0;j<grid[0].length;j++) {
        			side[i] = Math.max(side[i], grid[i][j]);
        			top[j] = Math.max(top[j], grid[i][j]);
        		}
        }
        
        int res = 0;
        for(int i=0;i<grid.length;i++) {
        		for(int j=0;j<grid[0].length;j++) {
        			res += (Math.min(side[i], top[j]) - grid[i][j]);
        		}
        }
    		return res;
    }
}
