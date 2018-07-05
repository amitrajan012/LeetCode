package medium;
/*
 * https://leetcode.com/problems/battleships-in-a-board/description/
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if(m==0) return 0;
        int n = board[0].length;
        
        int count = 0;
        for(int i=0;i<m;i++) {
        		for(int j=0;j<n;j++) {
        			if(board[i][j] == '.') continue;
        			if(i>0 && board[i-1][j] == 'X') continue; //Left one is already counted as battleship
        			if(j>0 && board[i][j-1] == 'X') continue; //Top one is already counted as battleship
        			count++;
        		}
        }
    		return count;
    }
}
