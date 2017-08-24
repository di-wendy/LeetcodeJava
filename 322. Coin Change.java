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
