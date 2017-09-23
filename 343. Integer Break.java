class Solution {
    public int integerBreak(int n) {
        //Sepecial Case
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[0] = 1;

        //Update
        for (int i = 2; i < n; i++){
            int temp = 1;
            for (int j = i - 1; j >= 0; j--){
                temp = Math.max(temp, dp[j] * (i - j));
            }
            dp[i] = temp;
        }
        
        int ans = 1;
        for (int j = n - 1; j > 0; j --){
            ans = Math.max(ans, dp[j] * (n - j));
        }
        //Result
        return ans;
    }
}
