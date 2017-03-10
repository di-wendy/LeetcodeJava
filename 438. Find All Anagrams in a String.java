//Time Limit Exceed
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int len = p.length();
        List<Integer> ans = new ArrayList<Integer> ();
        
        for(int i = 0; i < s.length() - len + 1; i++){
            if(isAnagram(s.substring(i,i+len),p)){
                ans.add(i);
            }
        }
        return ans;
        
    }
    
    public boolean isAnagram(String s, String t) {
        
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

