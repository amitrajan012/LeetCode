package easy;

public class PlusOne {
	public int[] plusOne(int[] digits) {		
		//If last digit is less than 9
		if(digits[digits.length-1] < 9){
			digits[digits.length-1] = digits[digits.length-1]+1;
			return digits;
		}
		
		//Else initialize carry and make last digit 0
		int carry = 1;
		digits[digits.length-1] = 0;
		for(int i=digits.length-2;i>=0;i--){
			int temp = digits[i]+carry;
			if(temp==10){
				//Store 0 and update carry as 1
				digits[i] = 0;
				carry = 1;
			}else{
				digits[i] = temp;
				//Reset carry before exiting the loop
				carry = 0;
				break;
			}
		}
		//If carry still exists return 1 as the Least significant bit
		if(carry==1){
			//Append 1 at the beginning
			int[] temp = new int[digits.length+1];
			temp[0] = 1;
			for(int i=0;i<digits.length;i++){
				temp[i+1] = digits[i];
			}
			return temp;
		}else{
			return digits;
		}
    }
}
