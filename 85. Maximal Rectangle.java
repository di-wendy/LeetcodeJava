class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] store = new int[r][c];
        
        int max = 0;
        
        for(int j = 0; j < c; j++){
            for(int i = 0; i< r; i++){
                calVertical(matrix, store, i, j);
            }
        }
        
        for(int i = 0; i < r; i++){
            max = Math.max(max, calHorizontal(store[i]));
        }
        
        return max;
    }
    
    public void calVertical(char[][] matrix, int[][] store, int i, int j){
        if(i == 0){
            store[i][j] = matrix[i][j] == '1'?1:0;
        }
        else{
            if(matrix[i][j] == '1'){
                store[i][j]  = store[i - 1][j] + 1;
            }
        }
    }
    
    public int calHorizontal(int[] array){
        int val = array[0];
        for(int i = 0; i < array.length; i++){
            int min = array[i];
            for(int j = i; j < array.length; j++){
                min = Math.min(min, array[j]);
                val = Math.max(val, (j - i + 1) * min);
            }
        }
        return val;
    }
}
