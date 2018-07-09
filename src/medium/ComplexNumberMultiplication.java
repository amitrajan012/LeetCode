package medium;
/*
 * https://leetcode.com/problems/complex-number-multiplication/description/
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int x1 = Integer.valueOf(a.substring(0, a.indexOf('+')));
        int y1 = Integer.valueOf(a.substring(a.indexOf('+')+1, a.length()-1));
        int x2 = Integer.valueOf(b.substring(0, b.indexOf('+')));
        int y2 = Integer.valueOf(b.substring(b.indexOf('+')+1, b.length()-1));
        
        int x = (x1*x2) - (y1*y2);
        int y = (x1*y2) + (x2*y1);
        
    		return "" + x + "+" + y + "i";
    }
}
