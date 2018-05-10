package easy;
import java.util.Arrays;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		//Java binary search solution
		//For each house, find it's position between the heaters. Hence heaters array needs to be sorted
		//Calculate the distance between each house and left and right heater and get a MIN value for these two values
		// [Corner cases: There is no left or right heater]
		//Get MAX value of all the MIN distances
		Arrays.sort(heaters);
		int result = Integer.MIN_VALUE;
		for(int house: houses) {
			int index = Arrays.binarySearch(heaters, house);
			if(index<0) {
				//Key not found
				index = -(index+1);
			}
			int distanceLeft = (index-1 >= 0) ? house - heaters[index-1] : Integer.MAX_VALUE;
			int distanceRight = (index < heaters.length) ? heaters[index] - house: Integer.MAX_VALUE;
			
			result = Math.max(result, Math.min(distanceLeft, distanceRight));
		}
		return result;
    }
}
