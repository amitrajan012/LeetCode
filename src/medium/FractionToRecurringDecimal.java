package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 */
public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        //Base case
		if(denominator == 1 || denominator == -1) {
			return Long.toString((long)numerator*(long)denominator);
		}
		if(numerator%denominator == 0) {
			return Integer.toString(numerator/denominator);
		}
		boolean negative = false;
		if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
			negative = true;
		}
		long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
		long partBeforeDecimal =  (numeratorL/denominatorL);
		long remainder = (numeratorL%denominatorL);
		StringBuilder partAfterDecimal = new StringBuilder();
		Map<Long, Integer> remainders = new HashMap<Long, Integer>();
		while(remainder != 0) {
			if(remainders.containsKey(remainder)) {
				//Recurring decimal found
				partAfterDecimal.insert((int)remainders.get(remainder), '(');
				partAfterDecimal.append(")");
				break;
			}
			partAfterDecimal.append(Long.toString((remainder*10)/denominatorL));
			remainders.put(remainder, partAfterDecimal.length()-1);
			remainder = (remainder*10)%denominatorL;
		}
		
		if(negative) {
			return new String("-").concat(Long.toString(partBeforeDecimal).concat(".").concat(partAfterDecimal.toString()));
		}
		return Long.toString(partBeforeDecimal).concat(".").concat(partAfterDecimal.toString());
    }
}
