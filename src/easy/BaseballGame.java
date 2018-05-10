package easy;
import java.util.Stack;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/baseball-game/description/
 *
 */
public class BaseballGame {
	public int calPoints(String[] ops) {
		Stack<Integer> roundScores = new Stack<Integer>();
		int sum = 0;
		for(String op: ops) {
			if(op.equals("C")) {
				//Cancel the last valid score
				int temp = roundScores.pop();
				sum -= temp;
			}else if(op.equals("D")) {
				int temp = 2*roundScores.peek();
				sum += temp;
				roundScores.push(temp);
			}else if(op.equals("+")) {
				int temp1 = roundScores.pop();
				int temp2 = roundScores.peek();
				int score = temp1+temp2;
				sum += score;
				roundScores.push(temp1);
				roundScores.push(score);
			}else {
				sum += Integer.valueOf(op);
				roundScores.push(Integer.valueOf(op));
			}
		}
		return sum;
    }
}
