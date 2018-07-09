package medium;
/*
 * https://leetcode.com/problems/minesweeper/description/
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(board[x][y] == 'M') {
        		board[x][y] = 'X';
        		return board;
        }
        helper(board, x, y);
    		return board;
    }

	private void helper(char[][] board, int x, int y) {
		if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y] != 'E') return;
		int mines = findMines(board, x, y);
		if(mines == 0) {
			board[x][y] = 'B';
			for (int i=-1;i<=1;i++) {
                for (int j=-1;j<=1;j++) {
                    helper(board, x+i, y+j);
                }
            }
		}else {
			board[x][y] = (char)('0'+mines);
		}
		
		
	}

	private int findMines(char[][] board, int x, int y) {
		int num = 0;
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				int x1 = x+i, y1 = y+j;
				if(x1<0 || x1>=board.length || y1<0 || y1>=board[0].length) continue;
				if(board[x1][y1] == 'M') num++;
			}
		}
		return num;
	}
}
