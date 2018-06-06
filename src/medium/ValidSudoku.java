package medium;
/*
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int N = 9; //As 9*9 Sudoku
		boolean[] Brow = new boolean[10];
		boolean[] Bcol = new boolean[10];
        for(int i=0;i<N;i++) {
        		Brow = new boolean[10];
        		Bcol = new boolean[10];
        		for(int j=0;j<N;j++) {
        			//Check for Row
        			if(board[i][j] != '.') {
        				int val = board[i][j] - '0';
        				if(Brow[val]) {
        					return false;
        				}else {
        					Brow[val] = true;
        				}
        			}
        			//Check for column
        			if(board[j][i] != '.') {
        				int val = board[j][i] - '0';
        				if(Bcol[val]) {
        					return false;
        				}else {
        					Bcol[val] = true;
        				}
        			}
        		}
        }
        
        int[] beginIndex = new int[] {0, 3, 6};
        int[] endIndex = new int[] {2, 5, 8};
        for(int i=0;i<3;i++) {
        		int rowStart = beginIndex[i];
        		int rowEnd = endIndex[i];
        		for(int j=0;j<3;j++) {
        			int colStart = beginIndex[j];
            		int colEnd = endIndex[j];
            		Brow = new boolean[10];
            		for(int m=rowStart;m<=rowEnd;m++) {
            			for(int n=colStart;n<=colEnd;n++) {
            				if(board[m][n] != '.') {
                				int val = board[m][n] - '0';
                				if(Brow[val]) {
                					return false;
                				}else {
                					Brow[val] = true;
                				}
                			}
            			}
            		}
        		}
        }
        
		return true;
    }
}
