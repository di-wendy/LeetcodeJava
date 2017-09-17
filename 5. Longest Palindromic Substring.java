class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        //Update Column first
        for (int j = 0; j < s.length(); j++){
            for (int i = j; i >= 0; i--){
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
                if (dp[i][j] && (res == null || j - i + 1 > res.length())){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
