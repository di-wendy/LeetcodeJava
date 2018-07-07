class Solution {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        //init
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++){
            int total = 0;
            for (int j = 1; j <= i; j++){
                total += (dp[j - 1] * dp[i - j]);
            }
            dp[i] = total;
        }
        return dp[n];
    }
}
