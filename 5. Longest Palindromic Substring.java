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

//DP2
class Solution {
    public String longestPalindrome(String s) {
        
        //store is whether string[i, j] is a palindrome substring or not
        int n = s.length();
        boolean[][] store = new boolean[n][n];
        String ans = "";
        
        for (int i = 0; i < n; i++){
            store[i][i] = true;
            if (i < n - 1){
                store[i][i + 1]  = (s.charAt(i) == s.charAt(i + 1));
            }
        }
        
        for (int j = 0; j < n; j++){
            for (int i = 0; i < n; i++){
                    if (i <= j){
                        if (s.charAt(i) == s.charAt(j) && i + 2 <= n && j - 1 >= 0 && store[i + 1][j - 1]){
                        store[i][j] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if(store[i][j] && j - i + 1 > ans.length()){
                    ans = s.substring(i, j + 1);
                }
            }
        }
        
        return ans;
    }
}