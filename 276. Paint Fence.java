public class Solution {
    public int numWays(int n, int k) {
        int a0 = k;
        int a1 = (int)Math.pow((double)k,(double)2);
        int a2 = a1*k - a0;
        int ans = 0;

        //Initialization
        if (n==0) return 0;
        if (n==1) return a0;
        if (n==2) return a1;
        if (n==3) return a2;
        
        for(int i=4; i<=n; i++){

            ans = a2*k - a0*(k-1);

            a0 = a1;
            a1 = a2;
            a2 = ans;
        }
        
        return ans;
    }
}
