public class Solution {
    public int climbStairs(int n) {
        
        int a0 = 1;
        int a1 = 2;
        int ans = 0;
        
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        
        for(int i=2; i<n; i++){
            ans = (a0+a1);
            a0 = a1;
            a1 = ans;
        }
        
        return ans;
    }
}
