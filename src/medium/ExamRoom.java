package medium;
/*
 * https://leetcode.com/problems/exam-room/description/
 */

import java.util.TreeSet;

class ExamRoom {
	TreeSet<Integer> set;
	int lastSeat;
    public ExamRoom(int N) {
        set = new TreeSet<>();
        lastSeat = N-1;
    }
    
    public int seat() {
		int seat;
		System.out.println(set);
		if(set.isEmpty()) {
    			seat = 0;
		}else {
    			int S = -1, gap = Integer.MIN_VALUE;
    			int previousSeat = set.first();
    			if(previousSeat != 0) {
    				S = 0;
    				gap = previousSeat-1;
    				previousSeat = 0;
    			}
    			for(int s: set) {
                System.out.println(s);
    				if(s > previousSeat) {
    					if(gap < (s-previousSeat)/2 - 1) {
    						S = previousSeat + (s-previousSeat)/2;
    						gap = (s-previousSeat)/2 - 1;
    					}
    				}
    				previousSeat = s;
    			}
    			if(gap < (lastSeat-previousSeat-1)) {
    				S = lastSeat;
    			}
    			seat = S;
		}
		System.out.println(seat);
		set.add(seat);
		System.out.println(set);
		return seat;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
