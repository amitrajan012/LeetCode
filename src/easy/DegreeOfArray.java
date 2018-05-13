package easy;

/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 */

public class DegreeOfArray {
	public int findShortestSubArray(int[] nums) {
		int[] degree = new int[50001];
		int[] startIndex = new int[50001];
		int[] endIndex = new int[50001];
		int maxElement = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			int temp = nums[i];
			maxElement = Math.max(maxElement, temp);
			if(degree[temp] == 0) {
				//First occurrence
				startIndex[temp] = i;
			}
			degree[temp] += 1;
			endIndex[temp] = i;
		}
		int maxDegree = 0;
		int smallestLength = Integer.MAX_VALUE;
		for(int i=0;i<=maxElement;i++) {
			if(maxDegree < degree[i]) {
				//Max degree element found: Element value is i
				maxDegree = degree[i];
				smallestLength = endIndex[i]-startIndex[i]+1;
			}else if(maxDegree == degree[i]) {
                smallestLength = Math.min(smallestLength, endIndex[i]-startIndex[i]+1);
            }
		}
		return smallestLength;
    }
}
