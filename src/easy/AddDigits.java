package easy;

public class AddDigits {
	public int addDigits(int num) {
        //This is a problem of digital roots
		//the digital root of a positive integer as the position it holds with respect to the largest multiple of 9 less than the number itself. 
		//the digital root of 11 is 2, which means that 11 is the second number after 9.
		//Likewise, the digital root of 2035 is 1, which means that 2035 − 1 is a multiple of 9. 
		//If a number produces a digital root of exactly 9, then the number is a multiple of 9.
		
		return num - 9*((num-1)/9);
    }
}
