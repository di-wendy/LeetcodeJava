public class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        
        int cur = 0;
        int ans = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        //Maximum on top
        
        for(int[] course: courses){
            cur += course[0];
            pq.add(course[0]);
            ans ++;
            if(cur > course[1]){
                cur -= pq.poll();
                ans --;
            }
        }
        
        return ans;
    }
}
