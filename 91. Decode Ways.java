class Solution {
    public int numDecodings(String s) {
        //Special Case
        if (s.length() == 0) return 0;
        
        //Data Structure Init
        int[] dp = new int[s.length() + 1];
        
        //Case Init
        dp[0] = 1;
        
        //Transition Function
        for (int i = 1; i <= s.length(); i++){
            //
            if (s.charAt(i - 1) - '0' != 0){
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && (s.charAt(i - 2) - '0' == 1 || (s.charAt(i - 2) - '0' == 2 && 
                                               s.charAt(i - 1) - '0' <= 6))){
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}
