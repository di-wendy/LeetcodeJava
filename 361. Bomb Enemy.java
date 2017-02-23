public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
        if(grid==null || grid.length<1) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int max = 0; //max enemy
        
        int row_e = 0; //enemy in current row
        int[] col = new int[m]; //enemy in jth col
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j==0 || grid[i][j-1]=='W'){
                    row_e = 0;
                    for(int k=j; k<m; k++){
                        if (grid[i][k]=='E') row_e += 1;
                        if (grid[i][k]=='W') break;
                    }
                }
                if(i==0 || grid[i-1][j]=='W'){
                    col[j] = 0;
                    for(int k=i; k<n; k++){
                        if (grid[k][j]=='E') col[j] += 1;
                        if (grid[k][j]=='W') break;
                    }
                }
                if(grid[i][j]=='0'){
                    max = Math.max(max, row_e+col[j]);
                }
            }
        }
        
        return max;
    }
}
