
public class MinMovesToEqualArrayElements {
	public int minMoves(int[] nums) {
        //Let minimum moves = m (after which every element equals X)
		// Sum + (n-1)m = n*X [As in every move n-1 elements are incremented]
		// Minimum number is incremented in every move
		// Hence, X = minNumber + m
		// Solving we get: m = Sum - minNumber*n
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			min = (nums[i] < min) ? nums[i] : min;
		}
		return sum - (min*nums.length);
    }
}
