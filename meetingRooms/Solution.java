package meetingRooms;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	 public boolean canAttendMeetings(Interval[] intervals) {
		 Arrays.sort(intervals, new Comparator<Interval>() {
			 public int compare(Interval i1, Interval i2) {
				 return Integer.compare(i1.start, i2.start);
			 }
		 });
		 
		 for (int i = 0; i < intervals.length - 1; i++) {
			 if (intervals[i].end > intervals[i + 1].start) {
				 return false;
			 }
		 }
		 return true;
	}
}
class Interval {
	int start;
	int end;
	Interval() { start = end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}