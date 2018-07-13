package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/knight-probability-in-chessboard/description/
 */
public class KnightProbabilityInChessboard {
    public double knightProbability(int N, int K, int r, int c) {
    		int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    		int len = N;
    		double dp[][] = new double[len][len];
    		for(double[] row: dp) Arrays.fill(row, 1); //Set initial probability to 1
    		
    		for(int l=0;l<K;l++) {
    			double[][] temp = new double[len][len];
    			for(int i=0;i<len;i++) {
    				for(int j=0;j<len;j++) {
    					for(int[] move: moves) {
    						int row = i+move[0];
    						int col = j+move[1];
    						if(row >= 0 && row < len && col >=0 && col < len) {
    							temp[i][j] += dp[row][col];
    						}
    					}
    				}
    			}
    			dp = temp;
    		}
    		return dp[r][c]/Math.pow(8, K);
    }
}
