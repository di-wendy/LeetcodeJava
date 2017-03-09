//27%
public class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) {
            return false;
        }
        
        char[] s_letters = s.toCharArray();
        char[] t_letters = t.toCharArray();
        
        Arrays.sort(s_letters);
        Arrays.sort(t_letters);

        for(int i = 0; i < s.length(); i++) {
            if(s_letters[i] != t_letters[i]){
                return false;
            }
        }
        
        return true;
    }
}

//54%
public class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) {
            return false;
        }
        
        int[] store = new int[26];
        
        for(int i=0; i<s.length(); i++){store[s.charAt(i)-'a'] ++;}
        for(int i=0; i<t.length(); i++){store[t.charAt(i)-'a'] --;}
        
        for(int i=0; i<26; i++){
            if(store[i] !=0){
                return false;
            }
        }
        return true;
    }
}
