package medium;
/*
 * https://leetcode.com/problems/game-of-life/description/
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
    		int MIN_ROW = 0, MIN_COL = 0, MAX_ROW = board.length-1, MAX_COL = board[0].length-1;
        for(int i=0;i<board.length;i++) {
        		for(int j=0;j<board[0].length;j++) {
        			int startRow = (i-1 < MIN_ROW) ? i : i-1;
        			int startCol = (j-1 < MIN_COL) ? j : j-1;
        			int endRow = (i+1 > MAX_ROW) ? i : i+1;
        			int endCol = (j+1 > MAX_COL) ? j : j+1;
        			int sum = 0;
        			for(int r=startRow;r<=endRow;r++) {
        				for(int c=startCol;c<=endCol;c++) {
        					if(!(i==r && j==c)) {
        						sum += (board[r][c] % 10);
        					}
        				}
        			}
        			board[i][j] += sum*10;
        		}
        }
        
        //Update cells to current state
        for(int i=0;i<board.length;i++) {
    			for(int j=0;j<board[0].length;j++) {
    				int curState = board[i][j]/10;
    				int prevState = board[i][j] % 10;
    				if(prevState == 0) { //Dead
    					if(curState == 3) board[i][j] = 1;
    					else board[i][j] = 0;
    				}else {
    					if(curState > 3) board[i][j] = 0;
    					else if(curState < 2) board[i][j] = 0;
    					else board[i][j] = 1;
    				}
    			}
        }
    }
}
