class Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : citations){
            pq.offer(n);
        }
        while (!pq.isEmpty()){
            int cur = pq.poll();
            if (cur >= pq.size() + 1) return pq.size() + 1;
        }
        return 0;
    }
}
