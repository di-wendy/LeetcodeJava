class Solution {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        balloons[0] = 1;
        balloons[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++){
            balloons[i] = nums[i - 1];
        }
        //DP init
        int[][] dp = new int[nums.length + 2][nums.length + 2]; //max coins to burst all ballons in the range
        for (int j = 2; j <= nums.length + 1; j++){
            for (int i = j - 2; i >= 0; i--){
                int max = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k++){
                    max = Math.max(dp[i][k] + dp[k][j] + balloons[i] * balloons[k] * balloons[j], max); //KEY
                }
                dp[i][j] = max;
            }
        }
        return dp[0][nums.length + 1];
    }
}
