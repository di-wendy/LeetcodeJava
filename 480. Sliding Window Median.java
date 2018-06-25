class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(Collections.reverseOrder()); //max -> min
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(); //min -> max
        double[] ans = new double[nums.length - k + 1];
        //Sliding window
        for (int i = 0; i < nums.length; i++){
            add(minQ, maxQ, nums[i]);
            if (i >= k) {
                remove(minQ, maxQ, nums[i - k], k); //Key
            }
            if (i >= k - 1){
                ans[i - k + 1] = (k % 2 == 0) ? minQ.peek()/2.0 + maxQ.peek()/2.0 : maxQ.peek();
            }
        }
        return ans;
    }
    
    public void add(PriorityQueue<Integer> minQ, PriorityQueue<Integer> maxQ, int n){
        minQ.offer(n);
        maxQ.offer(minQ.poll());
        if (maxQ.size() - minQ.size() > 1) minQ.offer(maxQ.poll());
    }
    
    public void remove(PriorityQueue<Integer> minQ, PriorityQueue<Integer> maxQ, int n, int k){
        if (n <= minQ.peek()) {
            minQ.remove(n);
            //if (n == -1) System.out.print(minQ.size() + " " + maxQ.size());
            if (maxQ.size() - minQ.size() > 1) minQ.offer(maxQ.poll());
        } else {
            maxQ.remove(n);
            //Key
            if (k % 2 == 0 && maxQ.size() < minQ.size()) maxQ.offer(minQ.poll());
            if (k % 2 == 1 && maxQ.size() <= minQ.size()) maxQ.offer(minQ.poll());
        }
    }
}
