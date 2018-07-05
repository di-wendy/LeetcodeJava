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

//HashMap
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), s.length());
            else{
                map.put(s.charAt(i), i);
            }
        }
        int i = s.length();
        for (int n : map.values()){
            i = Math.min(i, n);
        }
        return (i == s.length()) ? -1 : i;
    }
}
