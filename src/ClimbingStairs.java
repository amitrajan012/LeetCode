
public class ClimbingStairs {
	public int climbStairs(int n){
		//Corner cases
		if(n==1){
			return 1;
		}
		
		int[] steps = new int[n+1];
		steps[1] = 1;
		steps[2] = 2;
		for(int i=3;i<n+1;i++){
			steps[i] = steps[i-1]+steps[i-2];
		}
		return steps[n];
	}
}
