public class Solution {
    public int rob(int[] nums) {
        
        int prev_yes = 0;
        int prev_no = 0;
        
        for(int n: nums){
            int temp = prev_no;
            prev_no = Math.max(prev_no,prev_yes);
            prev_yes = n + temp;
        }
        
        return Math.max(prev_yes,prev_no);
    }
}
