public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2) return s;
        int n = s.length();
        boolean[][] store = new boolean[n][n];
        int max = 0;
        String ans = "";
        
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2||store[i+1][j-1]))
                    store[i][j]=true;
                else store[i][j]=false;
                
                if(store[i][j] && (j-i+1)>=max){
                    ans = s.substring(i,j+1);
                    max = (j-i+1);
                }
            }
        }
        
        return ans;
        
    }
}
