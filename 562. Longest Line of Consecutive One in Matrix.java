class Solution {
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int[][] h = deepCopy(M);
        int max = 0;
        for (int i = 0; i < h.length; i++){
            for (int j = 0; j < h[0].length; j++){
                if (i - 1 >= 0 && h[i][j] > 0){
                    h[i][j] += h[i - 1][j];
                }
                max = Math.max(max, h[i][j]);
            }
        }
        h = deepCopy(M);
        for (int i = 0; i < h.length; i++){
            for (int j = 0; j < h[0].length; j++){
                if (j - 1 >= 0 && h[i][j] > 0){
                    h[i][j] += h[i][j - 1]; 
                }
                max = Math.max(max, h[i][j]);
            }
        }
        h = deepCopy(M);
        for (int i = 0; i < h.length; i++){
            for (int j = 0; j < h[0].length; j++){
                if (j - 1 >= 0 && i - 1 >= 0 && h[i][j] > 0){
                    h[i][j] += h[i - 1][j - 1];
                }
                max = Math.max(max, h[i][j]);
            }
        }
        h = deepCopy(M);
        for (int i = 0; i < h.length; i++){
            for (int j = 0; j < h[0].length; j++){
                if (j + 1 < h[0].length && i - 1 >= 0 && h[i][j] > 0){
                    h[i][j] += h[i - 1][j + 1];
                }
                max = Math.max(max, h[i][j]);
            }
        }
        return max;
    }
    
    public int[][] deepCopy(int[][] M){
        int[][] h = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++){
            for (int j = 0; j < M[0].length; j++){
                h[i][j] = M[i][j];
            }
        }
        return h;
    }
}
