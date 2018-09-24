class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    public int slidingPuzzle(int[][] board) {
        //Visited Queue
        //For each step, expand the position in queue, generate 2 - 3 new states,
        //If state is not visited, put state in queue
        //If state is the final state, return step
        //If queue is Empty before step 4, return -1
        if (solved(board)) return 0;
        Queue<int[][]> state = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        //init
        int step = 0;
        state.offer(board);
        visited.add(stringify(board));
        //
        while (!state.isEmpty()){
            int size = state.size();
            for (int i = 0; i < size; i++){
                int[][] cur = state.poll();
                if (solved(cur)) return step;
                for (int d = 0; d < 4; ++d){
                    int[][] moved = move(cur, d);
                    if (!visited.contains(stringify(moved))){
                        state.offer(moved);
                        visited.add(stringify(moved));
                    }
                } 
            }
            step++;
        }
        return -1;
    }
    
    public String stringify(int[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++){
            sb.append(board[i/3][i%3]);
        }
        return sb.toString();
    }
    
    public boolean solved(int[][] board){
        for (int i = 0; i < 5; ++i){
            if (board[i/3][i%3] != i + 1) return false;
        }
        return board[1][2]==0;
    }
    
    public int[][] move(int[][] board, int direction){
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < 6; i++){
            res[i/3][i%3] = board[i/3][i%3];
        }
        int i = 0;
        for (; i < 6; ++i){
            if (res[i/3][i%3] == 0) break;
        }
        int r = i/3;
        int c = i%3;
        int newRow = r + dr[direction];
        int newCol = c + dc[direction];
        if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length){
            int temp = res[r][c];
            res[r][c] = res[newRow][newCol];
            res[newRow][newCol] = temp;
        }
        return res;
    }
}
