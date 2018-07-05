package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class MinimumNumberOfArrowsToBurstBallons {
	public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]); //Sort by end point
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
