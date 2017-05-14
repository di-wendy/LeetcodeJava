public class Solution {
    public int minDistance(String word1, String word2) {
        int common = getLongCommonSequence(word1, word2);
        return (word1.length() + word2.length() - common*2);
    }
    
    public int getLongCommonSequence(String word1, String word2){
        int m = word1.length();
        int n = word2.length();

        int max = 0;

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = (word1.charAt(i-1)==word2.charAt(j-1))?dp[i-1][j-1]+1:Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}
