class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        //Max more Alex can get from i to j
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        //Transition
        for (int j = 0; j < n; j++){
            for (int i = j - 1; i >= 0; i--){
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
