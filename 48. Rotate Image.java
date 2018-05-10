class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int m = matrix.length;
        //Transpose and flip
        for (int i = 0; i < m; i++){
            for (int j = i; j < m; j++){
                swap(matrix, i, j, j, i);
            }
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m / 2; j++){
                swap(matrix, i, j, i, m - j - 1);
            }
        }
        
        return;
    }
    
    public void swap(int[][] matrix, int i, int j, int k, int h){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][h];
        matrix[k][h] = temp;
    }
}
