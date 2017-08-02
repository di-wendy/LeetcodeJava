public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] test = new boolean[s1.length() + 1][s2.length() + 1];
        
        test[0][0] = true;
        
        //Initialize lines
        for(int i = 1; i <= s1.length(); i++){
            test[i][0] = test[i-1][0]&& (s1.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int j = 1; j <= s2.length(); j++){
            test[0][j] = test[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        
        //
        for(int i = 1; i <= s1.length(); i ++){
            for(int j = 1; j <= s2.length(); j++){
                test[i][j] = (test[i-1][j]&& (s1.charAt(i-1) == s3.charAt(i+j-1))) ||
                    (test[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)));
            }
        }
        
        return test[s1.length()][s2.length()];
    }
}