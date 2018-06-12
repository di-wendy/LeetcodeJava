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

//Hash 2
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length()) return false;
        for (char c : s.toCharArray()){
            count[c - 'a']++;
        }
        
        for (char c : t.toCharArray()){
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }
        return true;
    }
}
