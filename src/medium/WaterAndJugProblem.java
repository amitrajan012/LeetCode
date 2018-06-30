package medium;
/*
 * https://leetcode.com/problems/water-and-jug-problem/description/
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        //Base case
    		if(x+y < z) return false;
    		if(x==z || y==z || (x+y==z)) return true;
    		
    		return z%GCD(x, y) == 0;
    }
    
    public int GCD(int a, int b) {
    		while(b != 0) {
    			int temp = b;
    			b = a%b;
    			a = temp;
    		}
    		return a;
    }
}
