/**
 * 
 * @author amitrajan
 * https://leetcode.com/problems/perfect-number/description/
 */
public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		if(num==1) return false;
		int temp = (int)Math.sqrt(num);
		int sum = 1; //1 is a divisor of every number
		for(int i=2;i<=temp;i++) {
			if(num%i==0) {
				sum += i;
				sum += num/i;
			}
			if(sum>num)
				return false;
		}
		
		return (sum==num)? true: false;
    }
}
