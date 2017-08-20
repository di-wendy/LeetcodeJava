class Solution {
    public void solve(char[][] board) {

        if (board.length == 0 || board[0].length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == 'O') {
                q.add(new int[]{i,0});
                visited[i][0] = true;
            }
            if (board[i][board[0].length - 1] == 'O') {
                q.add(new int[]{i, board[0].length - 1});
                visited[i][board[0].length - 1] = true;
            };
        }
        
        for (int j = 1; j < board[0].length - 1; j++){
            if (board[0][j] == 'O'){
                q.add(new int[]{0,j});
                visited[0][j] = true;
            }
            if (board[board.length - 1][j] == 'O'){
                q.add(new int[]{board.length - 1,j});
                visited[board.length - 1][j] = true;
            }
        }
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i = 0; i < 4; i++){
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];
                if(x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                    if(board[x][y] == 'O' && !visited[x][y]){
                        board[x][y] = 'T';
                        visited[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }

        for (int i = 1; i < board.length - 1; i++){
            for (int j = 1; j < board[0].length - 1; j++){
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
