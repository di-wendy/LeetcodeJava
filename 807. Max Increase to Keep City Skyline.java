class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rowHighest = new int[m];
        int[] colHighest = new int[n];
        //Find highest building in each row
        for (int i = 0; i < m; i++){
            int high = 0;
            for (int j = 0; j < n; j++){
                high = Math.max(high, grid[i][j]);
            }
            rowHighest[i] = high;
        }
        //Find highest building in each colomn
        for (int j = 0; j < n; j++){
            int high = 0;
            for (int i = 0; i < m; i++){
                high = Math.max(high, grid[i][j]);
            }
            colHighest[j] = high;
        }
        //For each building, the tallest it can be reconstructed is to min(itsRowHigh, itsColHigh)
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans += Math.max(0, Math.min(rowHighest[i], colHighest[j]) - grid[i][j]);
            }
        }
        return ans;
    }
}
