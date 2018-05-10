package easy;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        //Solution Approach: Time Complexity should be logarithmic
		//We have to find the trailing zeroes which mean we have to find the maximum power of 5 that the factorial can have
		int count = 0;
		while (n>=5) {
		    n/=5;
		    count += n;
		  }
		return count;
    }
}
