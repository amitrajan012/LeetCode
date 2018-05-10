package easy;

public class GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		int i = 1, j = n;
	    while(i < j) {
	        int mid = i + (j - i) / 2;
	        if(guess(mid) == 0) {
	            return mid;
	        } else if(guess(mid) == 1) {
	            i = mid + 1;
	        } else {
	            j = mid;
	        }
	    }
	    return i;
    }

	private int guess(int n) {
		//API which returns higher or lower or equal
		return 0;
	}
}
