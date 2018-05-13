package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 */

public class ShortestDistanceToACharacter {
	public int[] shortestToChar(String S, char C) {
		List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] res = new int[S.length()];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < S.length(); i++) {
            for (int idx : list) {
            		res[i] = Math.min(res[i], Math.abs(idx - i));
            }
        }
        return res;
	}
}
