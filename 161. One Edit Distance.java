public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        if(Math.abs(s.length() - t.length()) > 1) return false;
        if(s.equals(t)) return false;

        boolean record = false;
        
        //One letter replaced
        if(s.length() == t.length()){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i)){
                    if(!record){
                        record = true;
                    }
                    else{
                        return false;
                    }
                }
            }
           return record;
        }

        //One letter missing
        int p = 0, q = 0;
        while(p < s.length() && q < t.length()){
            if(s.charAt(p) != t.charAt(q)){
                if(s.length() < t.length()){p--;}
                else {q--;}
                if(!record){
                        record = true;
                    }
                    else{
                        return false;
                    }
            }
            p++;
            q++;
        }
        return true;
    }
}
}
