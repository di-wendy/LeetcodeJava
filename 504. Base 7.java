public class Solution {
    public String convertToBase7(int num) {
        String ans = "";
        String prefix = (num<0)?"-":"";
        if(num == 0) return "0";
        
        //positive & negative
        
        while(num != 0){
            int temp = Math.abs((num%7));
            num = num/7;
            ans = temp + ans;
        }
        
        return prefix + ans;
    }
}