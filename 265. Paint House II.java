class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int[][] dp = new int[costs.length][costs[0].length];
        //Init
        for (int i = 0; i < costs[0].length; i++){
            dp[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < costs.length; i++){
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            int mark = -1;
            for (int j = 0; j < costs[0].length; j++){
                if (dp[i - 1][j] <= min) {
                    secondMin = min;
                    min = dp[i - 1][j];
                    mark = j;
                } else if(dp[i - 1][j] < secondMin){
                    secondMin = dp[i - 1][j];
                }
            }
            if (costs[0].length == 1) dp[i][0] = dp[i - 1][0] + costs[i][0];
            else{
                for (int j = 0; j < costs[0].length; j++){
                    if (j == mark) dp[i][j] = secondMin + costs[i][j];
                    else dp[i][j] = min + costs[i][j];
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++) ans = Math.min(ans, dp[costs.length - 1][j]);
        return ans;
    }
}
