package easy;

public class ConvertToHexadecimal {
	public String toHex(int num) {
		//Take a look at the last four digits of binary version of the input
		//Map it to a hexadecimal digit
		//Shift the input to the right by 4 bits
		//Do until input becomes 0
		
		//Base case
		if(num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		while(num != 0) {
			sb.insert(0, map[(num & 15)]);
			//Logical shift operator
			num = (num >>> 4);
		}
		return sb.toString();
    }
}
