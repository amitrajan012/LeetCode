package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
 */
public class LongestUncommonSubsequence1 {
	public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
