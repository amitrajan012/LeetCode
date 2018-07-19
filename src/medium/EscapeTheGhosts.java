package medium;
/*
 * https://leetcode.com/problems/escape-the-ghosts/description/
 */
public class EscapeTheGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        //You need to be closer to target than any ghost to escape.
    		int distance = Math.abs(target[0]) + Math.abs(target[1]);
    		for(int[] ghost: ghosts) {
    			if(distance >= Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1])) return false;
    		}
    		return true;
    }
}
