//DP
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        //Long P to cur char
        int ans = 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] += 2;
                    if (i - 2 >= 0) dp[i] += dp[i - 2];
                } else {
                    if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '('){
                        dp[i] += (dp[i - 1] + 2);
                        if (i - 2 - dp[i - 1] >= 0) dp[i] += dp[i - 2 - dp[i - 1]];
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
