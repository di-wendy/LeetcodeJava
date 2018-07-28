class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        //min cut when last cut is at ith letter
        //init
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        for (int i = 1; i <= s.length(); i++){
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--){
                //check from j + 1 to i
                if (dp[j] != Integer.MAX_VALUE && isPalin(s, j, i - 1)){
                    min = Math.min(min, dp[j]);
                }
            }
            dp[i] = min + 1;
        }
        return dp[s.length()];
    }
    
    public boolean isPalin(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
