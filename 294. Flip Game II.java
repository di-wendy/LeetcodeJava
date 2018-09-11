class Solution {
    public boolean canWin(String s) {
        Set<String> set = new HashSet();
        return helper(s, set);
    }
    
    public boolean helper(String s, Set<String> set){
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (set.contains(t) || !helper(t, set)){
                    return true;
                }
            }
        }
        set.add(s);
        return false;
   
