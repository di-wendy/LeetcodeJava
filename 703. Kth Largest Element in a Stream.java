class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(); //minHeap min -> max
        this.k = k;
        for (int n : nums) {
            if (pq.size() < k || n >= pq.peek()){
                pq.offer(n);
            }
            if (pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        if (pq.size() < k || val >= pq.peek()){
            pq.offer(val);
        }
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
