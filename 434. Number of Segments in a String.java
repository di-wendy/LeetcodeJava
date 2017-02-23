public class Solution {
    public int countSegments(String s) {
        
        s = s.trim();
        boolean in_word = false;
        int ans = 0;
        
        for(char a: s.toCharArray()){
            if (a!=' ' && !in_word){
                ans += 1;
                in_word = true;
            }
            else if(a==' ' && in_word){
                in_word = false;
            }
        }
        
        return ans;
    }
}
