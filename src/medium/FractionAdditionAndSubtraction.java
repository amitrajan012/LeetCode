package medium;

import java.util.Scanner;

/*
 * https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 */
public class FractionAdditionAndSubtraction {
    private Scanner scanner;

	public String fractionAddition(String expression) {
    		scanner = new Scanner(expression);
		Scanner sc = scanner.useDelimiter("/|(?=[-+])");
		int A = 0, B = 1;
		while(sc.hasNext()) {
			int a = sc.nextInt(), b = sc.nextInt();
			A = (A*b)+(a*B);
			B *= b;
			int g = GCD(A, B);
			A /= g;
			B /= g;
		}
    		return A + "/" + B;
    }

	private int GCD(int a, int b) {
		return a != 0 ? GCD(b % a, a) : Math.abs(b);
	}
}
