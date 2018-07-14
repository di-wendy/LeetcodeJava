class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> temp = new ArrayList<>();
        for (int[] b : buildings){
            temp.add(new int[]{b[0], b[2]});
            temp.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(temp, (a, b) -> {
            if (a[0] != b[0]) return a[0] < b[0] ? -1 : 1;
            else return a[1] > b[1] ? -1 : 1;
        });
        //Store Cur height
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(0); //Key
        List<int[]> ans = new ArrayList<>();
        int pre = 0;
        for (int[] b : temp){
            if (b[1] > 0) pq.offer(b[1]);
            else pq.remove(-b[1]);
            int cur = pq.peek();
            if (pre != cur){
                ans.add(new int[]{b[0], cur});
                pre = cur;
            }
        }

        return ans;
    }
}
