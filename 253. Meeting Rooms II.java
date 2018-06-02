/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return (a.start < b.start) ? -1 : 1; //Key, expect to be minus
            }
        });
            
        int curEnd = intervals[0].end;
        
        for (int i = 1; i < intervals.length; ++i){
            if (intervals[i].start < curEnd) return false;
            curEnd = intervals[i].end;
        }
        
        return true;
    }
}
