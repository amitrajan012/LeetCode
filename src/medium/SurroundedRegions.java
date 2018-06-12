package medium;
/*
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		//Base case : For single column and row as well
		if(board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}
        
		int row = board.length;
		int col = board[0].length;
		//Check first and last column
		for(int i=0;i<row;i++) {
			if(board[i][0] == 'O') marKAllConnectedOs(board, i, 1);
			if(board[i][col-1] == 'O') marKAllConnectedOs(board, i, col-2);
		}
		
		//Check first and last row
		for(int i=0;i<col;i++) {
			if(board[0][i] == 'O') marKAllConnectedOs(board, 1, i);
			if(board[row-1][i] == 'O') marKAllConnectedOs(board, row-2, i);
		}
		
		//Switch All Os to Xs and Ys to Os
		for(int i=1;i<row-1;i++) {
			for(int j=1;j<col-1;j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}else if(board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
    }

	private void marKAllConnectedOs(char[][] board, int row, int col) {
		if(row <= 0 || row >= board.length-1 || col <= 0 || col >= board[0].length-1) {
			return;
		}
		if(board[row][col] == 'X' || board[row][col] == 'Y') {
			return; //No need to go further as an X is encountered or Y is encountered(surrounding cells are processed)
		}
		
		if(board[row][col] == 'O') {
			board[row][col] = 'Y';
		}
		
		marKAllConnectedOs(board, row+1, col);
		marKAllConnectedOs(board, row-1, col);
		marKAllConnectedOs(board, row, col+1);
		marKAllConnectedOs(board, row, col-1);
	}
}
