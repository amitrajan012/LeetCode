package easy;
/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/largest-triangle-area/description/
 *
 */

public class LargestTriangleArea {
	public double largestTriangleArea(int[][] points) {
		double maxArea = 0;
		for(int i=0;i<points.length-2;i++) {
			for(int j=i+1;j<points.length-1;j++) {
				for(int k=j+1;k<points.length;k++) {
					maxArea = Math.max(maxArea, area(points[i], points[j], points[k]));
				}
			}
		}
		return maxArea;
    }
	
	private double area(int[] pt1, int[] pt2, int[] pt3) {
        return Math.abs(pt1[0] * (pt2[1] - pt3[1]) + pt2[0] * (pt3[1] - pt1[1]) + pt3[0] * (pt1[1] - pt2[1])) / 2.0; 
	}
}
