class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] money = new int[amount + 1];
        int sum = 0;
        while(++sum <= amount){
            int cur = -1;
            for (int coin : coins){
                if (sum - coin >= 0 && money[sum - coin] != -1){
                    int temp = money[sum - coin] + 1;
                    cur = cur < 0 ? temp : (temp < cur ? temp : cur);
                }
            }
            money[sum] = cur;
        }
        return money[amount];
    }
}
//Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++){
            int num = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0){
                    if (dp[i - coins[j]] != -1){
                        num = Math.min(dp[i - coins[j]] + 1, num);
                    }
                }
                dp[i] = (num == Integer.MAX_VALUE)?-1:num;
            }
        }
        
        return dp[amount];
    }
}
