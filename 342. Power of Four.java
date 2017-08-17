public class Solution {
    public boolean isPowerOfFour(int num) {
        boolean ans = true;
        int sum = 0;
        for (int i = 0; i < 32; i++){
            if(i%2 == 0) sum += (num >> i & 1);
            if(i%2 == 1) ans &= ((num >> i & 1) == 0);
        }   
        return ans & (sum == 1);
    }
}