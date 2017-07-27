public class Solution {
    public int singleNumber(int[] nums) {
        
        int res = 0;
        
        int[] bits = new int[32];
        
        for(int i = 0; i < 32; i++){
            for(int n:nums){
                bits[i] += (n >> i) & 1;
                bits[i] %= 3;
            }
            
            res |= bits[i] << i;
        }
        
        return res;
    }
}