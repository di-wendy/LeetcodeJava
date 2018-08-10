class Solution {
    public int cutOffTree(List<List<Integer>> f) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] < b[0] ? -1 : 1);
        for (int i = 0; i < f.size(); i++){
            for (int j = 0; j < f.get(0).size(); j++){
                if (f.get(i).get(j) != 0) pq.offer(new int[]{f.get(i).get(j), i, j});
            }
        }
        int step = 0;
        int preX = 0;
        int preY = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int ans = bfs(f, preX, preY, cur[1], cur[2]);
            if (ans == -1) return ans;
            step += ans;
            preX = cur[1];
            preY = cur[2];
        }
        return step;
    }
    
    public int bfs(List<List<Integer>> f, int s, int t, int x, int y){
        int step = 0;
        boolean[][] v = new boolean[f.size()][f.get(0).size()];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, t});
        v[s][t] = true;
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        while (!q.isEmpty()){
            int size = q.size();
            for (int j = 0; j < size; j++){
                int[] temp = q.poll();
                if (temp[0] == x && temp[1] == y) return step;
                for (int i = 0; i < 4; i++){
                    int newX = temp[0] + dx[i];
                    int newY = temp[1] + dy[i];
                    if (newX >= 0 && newX < f.size() && newY >= 0 && newY < f.get(0).size() 
                        && f.get(newX).get(newY) != 0 && !v[newX][newY]){
                        q.offer(new int[]{newX, newY});
                        v[newX][newY] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
