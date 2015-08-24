package meetingRooms2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(10, new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		return Integer.compare(i1.end, i2.end);
        	}
        });
        
        Arrays.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		return Integer.compare(i1.start, i2.start);
        	}
        });
        
        for (int i = 0; i < intervals.length; i++) {
        	if (queue.isEmpty()) {
        		Interval room = new Interval(intervals[i].start, intervals[i].end);
        		queue.add(room);
        	}
        	else {
        		Interval currentRoom = queue.peek();
        		if (currentRoom.end > intervals[i].start) {
        			queue.add(new Interval(intervals[i].start, intervals[i].end));
        		} else {
        			currentRoom = queue.poll();
        			currentRoom.end = intervals[i].end;
        			queue.add(currentRoom);
        		}
        	}
        }
        return queue.size();
    }
}



class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval (int s, int e) { start = s; end = e; }
	
}