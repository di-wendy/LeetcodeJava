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

//Second method
class Solution {
    public int firstUniqChar(String s) {
        int[] occur = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < 26; i++){
            index[i] = -1;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            occur[c - 'a'] ++;
            if (index[c - 'a'] == -1){
                index[c - 'a'] = i;
            }
        }
        int res = s.length();
        for (int i = 0; i < 26; i++){
            if (occur[i] == 1 && index[i] < res){
                res = index[i];
            }
        }
        return (res == s.length())?-1:res;
    }
}
