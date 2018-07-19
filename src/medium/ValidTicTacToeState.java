package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/valid-tic-tac-toe-state/description/
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        List<String> l = new ArrayList<>();
        for(String s: board) {
        		l.add(s);
        		for(char c: s.toCharArray()) {
        			if(c == 'X') countX++;
        			else if(c == 'O') countO++;
        		}
        }
        
        l.add("" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2));
        l.add("" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0));
        
        for(int i=0;i<3;i++) {
        		l.add("" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i));
        }
        
        int countXXX = 0, countOOO = 0;
        for(String row: l) {
        		if(row.equals("XXX")) countXXX++;
        		else if(row.equals("OOO")) countOOO++;
        }
        
        if(countX == countO+1) {
    			if(countXXX == 0 && countOOO == 0) return true;
    			if(countXXX >= 1 && countOOO == 0) return true;
        }else if(countX == countO) {
            if(countXXX == 0 && countOOO == 0) return true;
    			if(countXXX == 0 && countOOO >= 1) return true;
        }
    		return false;
    }
}
