public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character,Character> mp = new HashMap<Character,Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(!mp.containsKey(s.charAt(i))){
                if(mp.containsValue(t.charAt(i))){
                    return false;
                }
                mp.put(s.charAt(i),t.charAt(i));
            }
            else{
                if(t.charAt(i) != mp.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return true;   
    }
}
