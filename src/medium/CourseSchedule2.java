package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		int[] coursesReady = new int[numCourses]; //The one with values 0 will be ready to be taken
		int[] res = new int[numCourses];
		
		for(int i=0;i<prerequisites.length;i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0)
				coursesReady[ready]++; //duplicate case
			matrix[pre][ready] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>(); //Contains courses that can be taken
		for(int i=0;i<coursesReady.length;i++) {
			if(coursesReady[i] == 0) queue.offer(i);
		}
		int count = 0;
		while(!queue.isEmpty()) {
			int course = queue.poll();
			res[count] = course;
			count++;
			for(int i=0;i<numCourses;i++) {
				if(matrix[course][i] == 1) {
					if (--coursesReady[i] == 0)
	                    queue.offer(i);
				}
			}
		}
		
		return count == numCourses ? res : new int[0];
    }
}
