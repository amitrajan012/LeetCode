package medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/task-scheduler/description/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] C = new int[26];
        for(char c: tasks) {
        		C[c-'A']++;
        }
        Arrays.sort(C);
        int res = (C[25]-1)*(n+1); //Schedule first count-1 tasks of the task with maximum frequency which is count
        //Schedule each task that has value equal to maximum count by adding the last task of them
        //to the end of the frame and accommodating the remaining in between frames
        int index = 25;
        while(index >= 0 && C[index] == C[25]) {
        		res++;  
        		index--;
        }
        
        
        return Math.max(tasks.length, res);
    }
}
