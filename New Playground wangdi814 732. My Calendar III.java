class MyCalendarThree {
    TreeMap<Integer, Integer> book;
    public MyCalendarThree() {
        book = new TreeMap<Integer, Integer>();
    }
    
    public int book(int start, int end) {
        book.put(start, book.getOrDefault(start, 0) + 1);
        book.put(end, book.getOrDefault(end, 0) - 1);
        int active = 0, ans = 0;
        for (int key : book.keySet()) {
            active += book.get(key);
            if (active > ans) ans = active;
        }
        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
