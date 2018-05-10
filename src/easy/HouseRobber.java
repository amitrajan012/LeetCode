package easy;

public class HouseRobber {
	public int rob(int[] num) {
	    int rob = 0; // Rob current house
	    int notrob = 0; // Not rob current house
	    
	    for(int i=0; i<num.length; i++) {
	        int currob = notrob + num[i]; 
	        notrob = Math.max(notrob, rob);
	        rob = currob;
	    }
	    
	    return Math.max(rob, notrob);
	}
}
