class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) != t.charAt(j)){
                return check(s, t, i + 1, j) || check(s, t, i, j + 1) ||
                    check(s, t, i + 1, j + 1);
            }
            i++;
            j++;
        }
        return Math.abs(s.length() - t.length()) <= 1;
    }
    
    public boolean check(String s, String t, int i, int j){
        if ((s.length() - i) != (t.length() - j)) return false;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i++) != t.charAt(j++)) return false;
        }
        return true;
    }
}
