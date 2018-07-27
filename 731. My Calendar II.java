class MyCalendarTwo {
    List<int[]> l;
    List<int[]> o;
    public MyCalendarTwo() {
        l = new ArrayList<>();
        o = new ArrayList<>();
    }
    
    public boolean book(int s, int e) {
        o.clear(); //Key
        for (int[] cur : l){
            int maxS = Math.max(cur[0], s);
            int minE = Math.min(cur[1], e);
            if (maxS < minE){
                if (checkOverlap(maxS, minE)) return false;
            }
        }
        l.add(new int[]{s, e});
        return true;
    }
    
    public boolean checkOverlap(int s, int e){
        for (int[] cur : o){
            int maxS = Math.max(cur[0], s);
            int minE = Math.min(cur[1], e);
            if (maxS < minE){return true;}
        }
        o.add(new int[]{s, e});
        return false;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
