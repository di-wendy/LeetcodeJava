class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer preStart = map.floorKey(start);
        if (preStart != null && map.get(preStart).intValue() > start) return false;
        Integer afterStart = map.ceilingKey(start);
        if (afterStart != null && afterStart.intValue() < end) return false;
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
