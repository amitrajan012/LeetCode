package easy;

public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
        //Some useful tips:
		//Negate a number by bit manipulation -x = NOT(x)+1
		//Use AND operation to find carry
		//Use XOR operation to find different bit and assign it to a
		//Example: a=1=0001; b=3=0011
		//carry=a AND b = 0001
		//a XOR b = 0010
		//Assign XOR to a; a = 0010
		//Shift carry one bit to left and assign to b; b = 0010
		//Repeat until b is 0
		
		//Base case
		if(a==0) {
			return b;
		}
		if(b==0) {
			return a;
		}
		while(b!=0) {
			int carry = a&b;
			a = a^b;
			b = carry<<1;
		}
		return a;
    }
}
