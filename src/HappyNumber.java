import java.util.ArrayList;

public class HappyNumber {
	public boolean isHappy(int n) {
		//Unhappy numbers follow cycle -> 4, 16, 37, 58, 89, 145, 42, 20, 4...
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(n);
		
		while(n != 1) {
			int a = numSquareSum(n);
			
			if(a != 1 && temp.contains(a)) {
				return false;
			}
			
			temp.add(a);
			n = a;
		}
		
		return true;
    }
	
	int numSquareSum(int n)
	{
	    int squareSum = 0;
	    while (n != 0)
	    {
	        squareSum = squareSum + (n % 10) * (n % 10);
	        n = n/10;
	    }
	    return squareSum;
	}
}
