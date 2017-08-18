class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if(p.charAt(j) == '*' && dp[0][j-1]){
                dp[0][j+1] = true;
            }
        }
        
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(s.charAt(i) == p.charAt(j))
                    dp[i+1][j+1] = dp[i][j];
                
                if(p.charAt(j) == '.')
                    dp[i+1][j+1] = dp[i][j];
                
                if(p.charAt(j) == '*'){
                    if(s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.') 
                        dp[i+1][j+1] = dp[i+1][j-1]; //skip d[i+1][j], * is none
                    else{
                        dp[i+1][j+1] = 
                            //* is multiple letter
                            dp[i][j+1] || 
                            //* is none
                            dp[i+1][j-1] || 
                            //* is a letter
                            dp[i+1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
