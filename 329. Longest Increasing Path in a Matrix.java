class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] path = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int cur = findPath(matrix, path, i, j, Integer.MIN_VALUE);
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
    
    public int findPath(int[][] matrix, int[][] path, int i, int j, int pre){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre){
            return 0;
        }
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        int presum = 0;
        if (path[i][j] > 0) return path[i][j];
        for (int d = 0; d < 4; d++){
            presum = Math.max(presum, findPath(matrix, path, i + dx[d], j + dy[d], matrix[i][j]));
        }
        path[i][j] = presum + 1;
        return path[i][j];
    }
}
