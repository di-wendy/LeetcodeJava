public class Solution {
    public int calculate(String s) {
        if(s==null || s=="") return 0;
        int num = 0;
        int i = 0;
        char sign = '+';
        
        Stack <Integer> st = new Stack <Integer> ();
        
        while(i<s.length()){
            
            if(Character.isDigit(s.charAt(i))) num=num*10 + (s.charAt(i)-'0');
            
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ') || i==s.length()-1){
                if(sign=='+') st.push(num);
                if(sign=='-') st.push(-num);
                if(sign=='*'){
                    int cal = st.pop();
                    cal = num * cal;
                    st.push(cal);
                }
                if(sign=='/'){
                    int cal = st.pop();
                    cal = cal / num;
                    st.push(cal);
                }
                sign = s.charAt(i);
                num = 0;
            }
            i++;
        }
        
        int res = 0;
        for(int n: st){
            res += n;
        }
        
        return res;
    }
}
