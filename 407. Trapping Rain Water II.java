class Node{
    int x, y, value;
    public Node (int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int count = 0;
        if (heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return Integer.compare(a.value, b.value);
            }
        });
        //Put node in pq
        for (int i = 0; i < m; i++){
            pq.offer(new Node(i, 0, heightMap[i][0]));
            pq.offer(new Node(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++){
            pq.offer(new Node(0, j, heightMap[0][j]));
            pq.offer(new Node(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            for (int i = 0; i < 4; i++){
                int new_x = cur.x + dx[i];
                int new_y = cur.y + dy[i];
                if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n){
                    if(!visited[new_x][new_y]){
                        count += Math.max(0, cur.value - heightMap[new_x][new_y]);
                        pq.offer(new Node(new_x, new_y, Math.max(heightMap[new_x][new_y],cur.value))); //KEY
                        visited[new_x][new_y] = true;
                    }
                }
            }
        }
        
        return count;
    }
}
