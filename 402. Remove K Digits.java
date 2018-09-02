class Solution {
    public String removeKdigits(String num, int k) {
        String s = num;
        while (k >= 1){
            boolean remove = false;
            for (int i = 0; i < s.length() - 1; i++){
                if (s.charAt(i) > s.charAt(i + 1)){
                    if (i == 0) s = (i + 1 == s.length()) ? "0" : s.substring(i + 1, s.length());
                    else {
                        s = s.substring(0, i) + s.substring(i + 1, s.length());
                    }
                    remove = true;
                    break;
                }
            }
            if (!remove) s = s.substring(0, s.length() - 1); 
            s = removeZero(s);
            k--;
        }
        return s;
    }
    
    public String removeZero(String s){
        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == '0') i++;
            else break;
        }
        return (i == s.length()) ? "0" : s.substring(i, s.length());
    }
}
