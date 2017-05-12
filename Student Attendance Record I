public class Solution {
    public boolean checkRecord(String s) {
        
        boolean abs = false;
        boolean late = false;
        boolean late_again = false;
        
        for(char a:s.toCharArray()){
            if(a == 'A'){
                if(abs){return false;}
                else{abs = true;}
                late = false;
                late_again = false;
            }
            if(a == 'L'){
                if(late && late_again){return false;}
                else if(late){late_again = true;}
                else{late = true;}
            }
            if(a == 'P'){
                late = false;
                late_again = false;
            }
        }
        
        return true;
    }
}
