package easy;
import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
        int result = 0;
		
		for(int i=0;i<points.length;i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0;j<points.length;j++) {
				if(i == j) {
					continue;
				}
				int d = getDistanceSquared(points[i], points[j]);
				map.put(d, map.getOrDefault(d, 0)+1);
			}
			for(int val: map.values()) {
				//Compute permutation
				result += val*(val-1);
			}
		}
		return result;
    }
	
	private int getDistanceSquared(int[] a, int[] b) {
	    int dx = a[0] - b[0];
	    int dy = a[1] - b[1];
	    
	    return dx*dx + dy*dy;
	}
}
