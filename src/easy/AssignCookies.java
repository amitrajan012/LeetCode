package easy;
import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		for(int i=0; count < g.length && i < s.length; i++) {
			count += g[count]<=s[i] ? 1 : 0;
		}
		return count;
	}
}
