class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        
        boolean[][] store = new boolean[s.length() + 1][p.length() + 1];
        store[0][0] = true;
        
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i - 1) != '*'){
                break;
            }
            else{
                store[0][i] = true;
            }
        }
        
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= p.length(); j++){
                if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    store[i][j] = store[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    store[i][j] = store[i][j - 1] || store[i - 1][j];
                }
            }
        }
        
        return store[s.length()][p.length()];
    }
}
