class Solution {
    public int minSteps(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        //init
        dp[0] = 0;
        dp[1] = 0;
        //update
        for (int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int divide = 2;
            while (i/divide >= 1){
                if (i%divide == 0) min = Math.min(min, dp[i/divide] + divide);
                divide += 1;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
