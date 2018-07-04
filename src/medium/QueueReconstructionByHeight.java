package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
    		//Pick out the tallest group of people and sort them
    		//Since there is no other groups of people taller than them, each guy's index will be same as his k value
    		//Repeat this process for the entire group
    		//Example: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    		//Step1: [7,0], [7,1]
    		//Step2: In [7,0], [7,1] add [6,1] at index 1: [7,0], [6,1], [7,1]
    		//Step3: In [7,0], [6,1], [7,1] add [5,0], [5,2] at index 0 and 2 respectively (in order): [5,0], [7,0], [5,2], [6,1], [7,1]
    		//Step4: In [5,0], [7,0], [5,2], [6,1], [7,1] add [4,4] at index 4: [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
    	
    		if(people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
    		
    		//Sort according to height and in case of tie based on k
    		Arrays.sort(people, new Comparator<int[]>() {
    			public int compare(int[] a, int[] b) {
    				if(b[0] == a[0]) return a[1]-b[1];
    				return b[0]-a[0];
    			}
			});
    	
    		List<int[]> temp = new ArrayList<>();
    		for(int i=0;i<people.length;i++) {
    			temp.add(people[i][1], new int[] {people[i][0], people[i][1]}); //Add at the k value
    		}
    		
    		int[][] res = new int[people.length][2]; //Construct the solution
    		for(int i=0;i<temp.size();i++) {
    			res[i][0] = temp.get(i)[0];
    			res[i][1] = temp.get(i)[1];
    		}
    		return res;
    }
}
