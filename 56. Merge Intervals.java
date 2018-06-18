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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> ans = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval A, Interval B){
                return Integer.compare(A.start, B.start);
            }
        });
        int curStart = intervals.get(0).start;
        int curEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++){
            if (intervals.get(i).start <= curEnd) curEnd = Math.max(curEnd, intervals.get(i).end);
            else{
                ans.add(new Interval(curStart, curEnd));
                curStart = intervals.get(i).start;
                curEnd = intervals.get(i).end;
            }
        }
        ans.add(new Interval(curStart, curEnd));
        return ans;
    }
}
