package easy;

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		// 1162261467 is 3^19 and 3^20 is outside the range of integer  
	    return ( n>0 &&  1162261467%n==0);
    }
}
