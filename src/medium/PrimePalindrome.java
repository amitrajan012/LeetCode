package medium;
/*
 * https://leetcode.com/problems/prime-palindrome/description/
 */
public class PrimePalindrome {
    public int primePalindrome(int N) {
        //All palindromes with even digit is a multiple of 11 and hence are not prime
    		//We need to search for the one with odd digit
    		//Base case
    		if(8 <= N && N <= 11) return 11;
    		for(int x=1;x<100000;x++) {
    			//Form palindrome
    			String S = Integer.toString(x);
    			String R = new StringBuilder(S).reverse().substring(1); //To form palindrome of odd length
    			int temp = Integer.parseInt(S+R);
    			if(temp >= N && isPrime(temp)) return temp;
    		}
    		return -1;
    }

	private boolean isPrime(int x) {
		if (x < 2 || x % 2 == 0) return x == 2;
		for (int i=3;i*i<=x;i+=2) {
			if (x%i == 0) return false;	
		}
        return true;
	}
}
