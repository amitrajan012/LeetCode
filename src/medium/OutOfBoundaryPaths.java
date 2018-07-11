package medium;
/*
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 */
public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[m][n][N+1];
        int count = dfs(dp, i, j, N) % 1000000007;
        return count;
    }
    
    private final static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    private int dfs(int[][][] dp, int x, int y, int step){
        if(x<0 || y<0 || x>=dp.length || y>=dp[0].length) return 1; //Ball crossed the boundary
        
        if (x-step>=0 && x+step<dp.length && y-step>=0 && y+step<dp[0].length)  return 0; //As ball can't cross the boundary
        
        if(step<=0) return 0;
        
        if(dp[x][y][step]>0) return dp[x][y][step];
        
        int count = 0;
        for(int[] dir : dirs){
            int i = x + dir[0];
            int j = y + dir[1];
            count += dfs(dp, i, j, step-1);
            count %= 1000000007;
        }
        dp[x][y][step] = count;
        return count;
    }
}
