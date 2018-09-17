class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        //Init
        for (int i = 0; i < n; i++) {
            costs.putIfAbsent(i, new HashMap<>());
            if (i == src) costs.get(i).put(0, 0);
            else costs.get(i).put(0, Integer.MAX_VALUE);
        }
        //Store all outgoing edges
        for (int[] f : flights){
            map.putIfAbsent(f[0], new HashMap<>());
            map.get(f[0]).put(f[1], f[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            //if (cur[1] == 2) System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
            if (cur[2] > K + 1) continue;
            if (cur[1] == dst) return cur[0];
            if (map.containsKey(cur[1])){
                for (int v : map.get(cur[1]).keySet()){
                    int ncost = cur[0] + map.get(cur[1]).get(v);
                    if (ncost < costs.get(v).getOrDefault(cur[2] + 1, Integer.MAX_VALUE)){
                        costs.get(v).put(cur[2] + 1, ncost);
                        pq.offer(new int[]{ncost, v, cur[2] + 1});
                    }
                } 
            }
        }
        return -1;
    }
}
