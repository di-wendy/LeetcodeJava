public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //minutesToTest/minutesToDie is the base
        //buckets is the number
        
        int base = minutesToTest/minutesToDie + 1;
        
        double ans = Math.log(buckets)/Math.log(base);
        
        return (int)Math.ceil(ans);
    
    }
}
