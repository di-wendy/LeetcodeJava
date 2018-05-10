class MedianFinder {
    //Priority Queue default is min -> max, poll(min)
    /** initialize your data structure here. */
    PriorityQueue<Integer> topQ, bottomQ;

    public MedianFinder() {
        topQ = new PriorityQueue<Integer>(); //store minimum
        bottomQ = new PriorityQueue<Integer>(Collections.reverseOrder()); //max -> min bottom
    }

    public void addNum(int num) {
        bottomQ.offer(num); //put into bottom
        topQ.offer(bottomQ.poll()); //minQ get the max from bottom
        if (topQ.size() > bottomQ.size()){ //if top > bottom
            bottomQ.offer(topQ.poll()); //bottom get the min from top
        }
    }

    public double findMedian() {
        if (bottomQ.size() == topQ.size()){
            return bottomQ.peek() / 2.0 + topQ.peek() / 2.0;
        }
        return bottomQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */