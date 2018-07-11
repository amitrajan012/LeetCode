package medium;

import java.util.Scanner;

/*
 * https://leetcode.com/problems/solve-the-equation/description/
 */
public class SolveTheEquation {
	private Scanner scanner;
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String lhs = split[0];
        String rhs = split[1];
        
        scanner = new Scanner(lhs);
        Scanner sclhs = scanner.useDelimiter("(?=[-+])");
        
        int lhsConstant = 0;
        int lhsFactorX = 0;
        while(sclhs.hasNext()) {
        		String term = sclhs.next();
        		if(!term.contains("x")) {
        			lhsConstant += Integer.parseInt(term);
        		}else {
        			if(term.length() == 1) {
        				lhsFactorX += 1;
        			}else if(term.length() == 2 && (term.charAt(0) == '+' || term.charAt(0) == '-')) {
        				lhsFactorX += (term.charAt(0) == '+') ? 1 : -1;
        			}else {
        				lhsFactorX += Integer.parseInt(term.substring(0, term.length()-1));	
        			}
        		}
        }
        
        scanner = new Scanner(rhs);
        Scanner scrhs = scanner.useDelimiter("(?=[-+])");
        int rhsConstant = 0;
        int rhsFactorX = 0;
        while(scrhs.hasNext()) {
        		String term = scrhs.next();
        		if(!term.contains("x")) {
        			rhsConstant += Integer.parseInt(term);
        		}else {
        			if(term.length() == 1) {
        				rhsFactorX += 1;
        			}else if(term.length() == 2 && (term.charAt(0) == '+' || term.charAt(0) == '-')) {
        				rhsFactorX += (term.charAt(0) == '+') ? 1 : -1;
        			}else {
        				rhsFactorX += Integer.parseInt(term.substring(0, term.length()-1));
        			}
        		}
        }
        
        int factor = lhsFactorX - rhsFactorX;
        int constant = rhsConstant - lhsConstant;
        
        if(factor == 0 && constant == 0) return "Infinite solutions";
        else if(factor == 0) return "No solution";
        else return "x=" + constant/factor;
    }
}
