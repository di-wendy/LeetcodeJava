public class Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int val = 0;
        
        for(int n:nums){
            int temp = val;
            val = Math.max(val, pre + n);
            pre = temp;
        }
        
        return val;
    }
}
