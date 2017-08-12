public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if( m == 0 || n == 0)
            return 0;
        
        int[][] f = new int[m][n];
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        //Init
        for(int i = 0; i < m; i++){
                f[i][0] = (obstacleGrid[i][0] == 1 || (i >= 1 && f[i - 1][0] == 0))?0:1;
        }
        
        for(int j = 0; j < n; j++){
                f[0][j] = (obstacleGrid[0][j] == 1 || (j >= 1 &&f[0][j - 1] == 0))?0:1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = (obstacleGrid[i][j] == 1)?0:f[i-1][j] + f[i][j-1];
            }
        }
        
        return f[m - 1][n - 1];
    }
}
