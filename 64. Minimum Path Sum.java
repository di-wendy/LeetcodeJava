public class Solution {
    public int minPathSum(int[][] grid) {
        
        //Assume sum < Integer.MAX_VALUE
        //Initialization
        if(grid.length == 0 || grid[0].length == 0) return 0;
        
        int[][] store = new int[grid.length][grid[0].length];
        store[0][0] = grid[0][0];
        
        for(int i = 1; i < grid.length; i++){
            store[i][0] = store[i-1][0] + grid[i][0];
        }
        
        for(int i = 1; i < grid[0].length; i++){
            store[0][i] = store[0][i-1] + grid[0][i];
        }
        
        //DP
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                store[i][j] = Math.min(store[i-1][j],store[i][j-1]) + grid[i][j];
            }
        }
        
        return store[grid.length - 1][grid[0].length - 1];
        
    }
}