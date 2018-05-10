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

//Another
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long start = 1;
        long end = x/2;

        while (start + 1 < end){
            long mid = start + (end - start)/2;
            if (mid * mid > x){
                end = mid;
            }
            else {
                start = mid;
            }
        }

        return (end * end <= x)?(int)end:(int)start;
    }
}
