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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        //Sweep Line
        List<Interval> ans = new ArrayList<>();
        if (schedule.size() == 0) return ans;
        
        List<Interval> time = new ArrayList<>();
        
        for (List<Interval> s : schedule) time.addAll(s);
        Collections.sort(time, (a, b) -> {
            if (a.start != b.start) return a.start < b.start ? -1 : 1;
            else return a.end < b.end ? -1 : 1;
        });
        
        int end = time.get(0).end;
        for (int i = 1; i < time.size(); i++){
            if (time.get(i).start > end){
                ans.add(new Interval(end, time.get(i).start));
                end = time.get(i).end;
            } else {
                end = Math.max(end, time.get(i).end);
            }
        }
        
        return ans;
    }
}
