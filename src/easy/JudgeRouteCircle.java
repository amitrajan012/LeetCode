package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/judge-route-circle/description/
 *
 */
public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
		int LR = 0, UD = 0;
		//Converting string to character array yields better performance!!!!
		for(char c: moves.toCharArray()) {
			switch (c) {
			case 'U': UD++;
				break;
			case 'D': UD--;
				break;
			case 'L': LR--;
				break;
			case 'R': LR++;
				break;
			}
		}
		return (LR == 0 && UD == 0);
    }
}
