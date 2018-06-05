package medium;
/*
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		//Base case
		if(height.length == 2) {
			return Math.min(height[0], height[1]);
		}
		
		int maxArea = Integer.MIN_VALUE;
		int left = 0, right = height.length - 1;
		int leftMax = height[0], rightMax = height[right];
		int area = 0;
		while(left < right) {
			if(leftMax < rightMax) {
				area = (right - left) * leftMax;
				left++;
				if(leftMax < height[left]) {
					leftMax = height[left];
				}
			}else {
				area = (right - left) * rightMax;
				right--;
				if(rightMax < height[right]) {
					rightMax = height[right];
				}
			}
			if(area > maxArea)
				maxArea = area;
		}
		return maxArea;
    }
}
