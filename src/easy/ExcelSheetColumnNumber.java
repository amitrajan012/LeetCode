package easy;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		//Hence this is a base 26 problem, i.e. We have to convert the string to base 26 number
		//A is 1 rather than 0
		int number = 0;
		for(int i=0;i<s.length();i++) {
			number = number + ((int) (s.charAt(i)) - 64) * (int) (Math.pow(26, s.length()-i-1));
		}
		return number;
    }
}
