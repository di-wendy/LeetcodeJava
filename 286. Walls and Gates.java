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
