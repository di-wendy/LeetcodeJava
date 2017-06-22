public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] store = new int[m+1][n+1]; //m row; n col;
        
        for(int i = 0; i <= m; i ++){
            store[i][0] = i;
        }
        
        for(int i = 0; i <= n; i ++){
            store[0][i] = i;
        }        
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    store[i][j] = store[i-1][j-1];
                }
                else{
                    int ins = store[i][j-1];
                    int del = store[i-1][j];
                    int rep = store[i-1][j-1];
                    store[i][j] = Math.min(ins,Math.min(del,rep)) + 1;
                }
            }
        }
        
        return store[m][n];
    }
}
