class Solution {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int x, int y, int cur){
        if (cur > rooms[x][y]){
            return;
        }
        rooms[x][y] = cur;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for (int i = 0; i < 4; i++){
            int x_new = x + dx[i];
            int y_new = y + dy[i];
            if (x_new >= 0 && x_new < rooms.length && y_new >=0 && y_new < rooms[0].length){
               dfs(rooms, x_new, y_new, cur + 1);
            }
        }
    }
}

//BFS
class Node{
    int x, y, val;
    public Node(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        //Put gates in queue
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0) q.offer(new Node(i, j, rooms[i][j]));
            }
        }
        //BFS points in Queue, when point.value + 1 < surrounding.value && not wall, update, put in queue
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while (!q.isEmpty()){
            Node cur = q.poll();
            for (int i = 0; i < 4; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n){
                    if (cur.val + 1 < rooms[newX][newY]){
                    q.offer(new Node(newX, newY, cur.val + 1));
                    rooms[newX][newY] = cur.val + 1;
                    }
                }
            }
        }
    }
}
