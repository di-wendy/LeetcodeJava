class Solution {
    public int[][] candyCrush(int[][] board) {
        while(crash(board)){
            drop(board);
        }
        return board;
    }
    
    public boolean crash(int[][] b){
        boolean[][] changed = new boolean[b.length][b[0].length];
        boolean crashed = false;
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < b[0].length; j++){
                if (b[i][j] != 0){
                    changed[i][j] = check(b, i, j);
                }
                
            }
        }
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < b[0].length; j++){
                if (changed[i][j]) {
                    crashed = true;
                    b[i][j] = 0;
                }
            }
        }
        return crashed;
    }
    
    public boolean check(int[][] b, int i, int j){
        if (i + 2 < b.length && b[i + 1][j] == b[i][j] && b[i + 2][j] == b[i][j]) return true;
        if (i - 2 >= 0 && b[i - 1][j] == b[i][j] && b[i - 2][j] == b[i][j]) return true;
        if (j + 2 < b[0].length && b[i][j + 1] == b[i][j] && b[i][j + 2] == b[i][j]) return true;
        if (j - 2 >= 0 && b[i][j - 1] == b[i][j] && b[i][j - 2] == b[i][j]) return true;
        if (i - 1 >= 0 && i + 1 < b.length && b[i + 1][j] == b[i][j] && b[i - 1][j] == b[i][j]) return true;
        if (j - 1 >= 0 && j + 1 < b[0].length && b[i][j - 1] == b[i][j] && b[i][j + 1] == b[i][j]) return true;
        return false;
    }
    
    public void drop(int[][] b){
        for (int j = 0; j < b[0].length; j++){
            int s = b.length - 1, e = b.length - 1;
            while (e >= 0){
                if (b[e][j] != 0){
                    b[s][j] = b[e][j];
                    s--;
                }
                e--;
            }
            for (int k = s; k >= 0; k--) b[k][j] = 0;
        }
    }
}
