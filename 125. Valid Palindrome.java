//Case Conversion Character.toUpperCase
//Character.isLetterOrDigit
//75%
public class Solution {
    public boolean isPalindrome(String s) {
        
        if(s=="") return true;
        
        int n = s.length();
        
        int p1 = 0;
        int p2 = n-1;
        
        char[] letters = s.toCharArray();
        
        while(p1 < p2){
            while(!Character.isLetterOrDigit(letters[p1]) && p1 < n - 1) {p1++;}
            while(!Character.isLetterOrDigit(letters[p2]) && p2 > 0) {p2--;}
            if((p1<p2) && Character.toUpperCase(letters[p1]) != Character.toUpperCase(letters[p2])) {
                return false;
            }
            p1++;
            p2--;
        }
        
        return true;
    }
}
