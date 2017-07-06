public class Solution {
    public int uniquePaths(int m, int n) {
        
        if(m == 0 || n == 0) return 0;
        
        int[][] store = new int[m][n];
        
        store[0][0] = 1;
        
        for(int i = 0; i < m; i ++){
            store[i][0] = 1;
        }
        
        for(int j = 0; j < n; j++){
            store[0][j] = 1;
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++){
                store[i][j] = store[i - 1][j] + store[i][j - 1];
            }
        }
        
        return store[m-1][n-1];
    }
}