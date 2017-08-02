public class Solution {
    public int numDistinct(String s, String t) {
        
        if(t.length() > s.length()) return 0;
        
        int[][] test = new int[t.length() + 1][s.length() + 1];
        
        for(int j = 0; j <= s.length(); j++){
            test[0][j] = 1;
        }
        
        for(int i = 0; i < t.length(); i++){
            for(int j = 0; j < s.length();j++){
                if(t.charAt(i) == s.charAt(j)){
                    test[i+1][j+1] = test[i][j] + test[i+1][j];
                }
                else{
                    test[i+1][j+1] = test[i+1][j];
                }
            }
        }
        
        return test[t.length()][s.length()];
    }
}