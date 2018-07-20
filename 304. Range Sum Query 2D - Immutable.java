class NumMatrix {
    long[][] presum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0){
            int m = matrix.length, n = matrix[0].length;
            presum = new long[m][n];
            presum[0][0] = matrix[0][0];
            for (int i = 1; i < m; i++) presum[i][0] = presum[i - 1][0] + matrix[i][0];
            for (int j = 1; j < n; j++) presum[0][j] = presum[0][j - 1] + matrix[0][j];
            for (int i = 1; i < m; i++){
                for (int j = 1; j < n; j++){
                    presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        long region1 = (row1 - 1 >= 0 && col1 - 1 >= 0) ? presum[row1 - 1][col1 -1] : 0;
        long total = presum[row2][col2];
        long regionLeft = (col1 - 1 >= 0) ? presum[row2][col1 - 1] : 0;
        long regionUp = (row1 - 1 >= 0) ? presum[row1 - 1][col2] : 0;
        return (int) (total - regionLeft - regionUp + region1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
