
public class Sqrt {
	public int mySqrt(int x) {
		//Base case
		if(x<2){
			return x;
		}
		
		//Using Newton method
		long r = x/2;
		while(r*r >x){
			r = (r+x/r)/2;
		}
		
		return (int)r;
    }
}
