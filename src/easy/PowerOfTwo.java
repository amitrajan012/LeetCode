package easy;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		//Alternate solution : We can check all the leftmost bits to be equal to 0 
		//Base case
		if(n<1) {
			return false;
		}
        while(n>1) {
        		if(n%2 == 0) {
        			n = n/2;
        		}else {
        			return false;
        		}
        }
        return true;
    }
}
