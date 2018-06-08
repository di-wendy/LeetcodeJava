class Solution {
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount + 1];
        ways[0] = 1;
        for (int coin : coins){
            for (int i = 1; i <= amount; i++){
                if (coin <= i) ways[i] += ways[i - coin];
            }
        }
        return ways[amount];
    }
}
