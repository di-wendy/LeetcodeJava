public class Solution {
    public int myAtoi(String str) {
        
        if(str == null || str.length() < 1){
            return 0;
        }
        
        str = str.trim();
        
        char sign = '+';
        int index = 0;
        
        if(str.charAt(0) == '-'){
            sign = '-';
            index = 1;
        }
        else if(str.charAt(0) == '+'){
            index = 1;
        }
        
        double res = 0;
        
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            res *= 10;
            res += str.charAt(index) - '0';
            index += 1;
        }
        
        res = (sign=='-'?-1*res:res);
        
        if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int) res;
    }
}
