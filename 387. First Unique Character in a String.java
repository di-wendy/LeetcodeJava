public class Solution {
    public int firstUniqChar(String s) {
        
        int ans = -1;
        
        int[] frq = new int[26];
        
        for(int i=0; i<s.length(); i++){
            frq[s.charAt(i)-'a'] ++;
        }
        
        for(int i=0; i<s.length(); i++){
            if(frq[s.charAt(i)-'a']==1) return i;
        }
        
        return ans;
    }
}
