public class Solution {
    public int titleToNumber(String s) {
        
        int ans = 0;
        char[] letters = s.toCharArray();
        
        for(char a:letters){
            ans *= 26;
            ans += (a-'A'+1);
        }
        
        return ans;
    }
}
