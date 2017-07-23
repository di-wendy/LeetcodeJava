public class Solution {
    public int countSubstrings(String s) {
        
        int ans = 0;
        ans += s.length();
        
        for(int i = 2; i <= s.length(); i++){
            for(int j = 0; j <= s.length() - i; j++){
                if(isPalindrome(s, j,j + i - 1)){
                    ans ++;
                }
            }
        }
        return ans;
    }
    
    public boolean isPalindrome(String s, int low, int high){
        
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        
        return true;
    }
}
