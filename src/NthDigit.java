
public class NthDigit {
	public int findNthDigit(int n) {
        int len = 1;
        int count = 9;
		int start = 1;
        
		while(n > len*count ) {
			n = n-len*count;
			count = count*10;
			start = start*10;
		}
        
		start = start + (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
