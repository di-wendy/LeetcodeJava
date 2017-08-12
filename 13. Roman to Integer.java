public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('M',1000);
        mp.put('D',500);
        mp.put('C',100);
        mp.put('L',50);
        mp.put('X',10);
        mp.put('V',5);
        mp.put('I',1);
        
        char[] chars = s.toCharArray();
        
        int ans = 0;
        
        for(int i = 0; i < s.length() - 1; i++){
            if(mp.get(chars[i]) < mp.get(chars[i+1])){
                ans -= mp.get(chars[i]);
            }
            else{
                ans += mp.get(chars[i]);
            }
        }
        
        ans += mp.get(chars[s.length() - 1]);
        
        return ans;
    }
}
