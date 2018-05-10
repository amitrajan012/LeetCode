package easy;

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		//Perfect Square is of the form 1+3+5+7+...
		int i = 1;
		while(num>0) {
			num = num-i; 
			i = i+2;
		}
		return num==0;
    }
}
