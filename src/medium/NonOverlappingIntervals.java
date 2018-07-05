package medium;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length == 0) return 0;
		
		//Sort by end point ascending order
		Arrays.sort(intervals, new myComparator());
		//Count maximum number of overlapping intervals
		int end = intervals[0].end;
		int count = 1;
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i].start >= end) {
				count++;
				end = intervals[i].end;
			}
		}
    		return intervals.length - count;
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
