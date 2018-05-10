package easy;

public class NumberComplement {
	public int findComplement(int num) {
        int neg = ~num;
        while(num != 0) {
        		if((num & (num-1)) == 0) {
        			//This means num-1 is the inverted form 
        			break;
        		}
        		num = num & (num-1);
        }
        //If num is of the form 100 : neg =111011 and num-1=011 and hence num-1 will be the final result
      //If num is of the form 101 : neg =111010 and num-1=011 (eventually) and hence num-1 will be the final result
        return neg & (num-1);
    }
}
