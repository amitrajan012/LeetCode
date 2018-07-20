package medium;
/*
 * https://leetcode.com/problems/push-dominoes/description/
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
    		String next = findNextState(dominoes);
        while(!dominoes.equals(next)) {
        		dominoes = next;
        		next = findNextState(dominoes);
        }
        return next;
    }

	private String findNextState(String dominoes) {
		StringBuilder nextState = new StringBuilder();
        for(int i=0;i<dominoes.length();i++) {
        		if(dominoes.charAt(i) == 'L' || dominoes.charAt(i) == 'R') {
        			nextState.append(dominoes.charAt(i));
        			continue;
        		}
        		char left, right;
        		
        		if(i>=1) left = dominoes.charAt(i-1);
        		else left = '.';
        		if(i<=dominoes.length()-2) right = dominoes.charAt(i+1);
        		else right = '.';
        		
        		if(left == 'R' && right != 'L') nextState.append('R');
        		else if(right == 'L' && left != 'R') nextState.append('L');
        		else nextState.append('.');
        }
		return nextState.toString();
	}
}
