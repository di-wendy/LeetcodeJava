public class HitCounter {
     
    private Integer [] time; //0-300
    private Integer [] hit; //0 - n

    /** Initialize your data structure here. */
    public HitCounter() {
        time = new Integer[300];
        hit = new Integer[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int key = timestamp%300;
        if (time[key]!=null&&time[key]==timestamp) hit[key]++;
        else{
            time[key] = timestamp;
            hit[key] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        //sum up the number in time[]
        for(int i=0; i<300; i++){
            if(time[i]==null) continue;
            if(timestamp-time[i]>=300) continue;
            count += hit[i];
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
