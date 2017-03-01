//Wrong Answer

public class Solution {
    public int mySqrt(int x) {
        
        if(x==0) return 0;
        
        int ans = 0;
        
        for(int i= 1; i<=x; i++){
            if(i*i>x) 
            {ans = i;
            break;}
        }
        
        int dif1 = ans*ans - x;
        int dif2 = x - (ans-1)*(ans-1);
        
        if(dif2<dif1) return ans-1;
        else return ans;
        
    }
}
