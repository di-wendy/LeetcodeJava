public class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length() || s.length() == 0 || t.length() == 0)
            return "";
        
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        
        for(char c:t.toCharArray()){
            m2[c]++;
        }
 
        int i = 0;
        int j = 0;
        int minvalue = s.length();
        
        String res = "";

        while(i < s.length()){
            while(j < s.length() && !isvalid(m1,m2)){
                m1[s.charAt(j)] ++;
                if(j < s.length()) j++;
            }
            if(j - i <= minvalue && isvalid(m1,m2)){
                res = s.substring(i, j);
                minvalue = Math.min(minvalue,j - i);
            }
            
            m1[s.charAt(i)]--;
            i++;
        }
        return res;
    }
    
    public boolean isvalid(int[] m1, int[] m2){
        for(int i = 0; i < m2.length; i++){
            if(m1[i] < m2[i])
                return false;
        }
        return true;
    }

}
