public class Solution {

    public int rob(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        int ans = 0;
        
        for(int i = 0; i < nums.length; i ++){
            int prev_yes = 0;
            int prev_no = 0;
            for( int j = i; j < nums.length + i - 1; j ++){
                int temp = prev_no;
                prev_no = Math.max(prev_no,prev_yes);
                prev_yes = nums[j%nums.length] + temp;
            }
            int stepmax = Math.max(prev_no,prev_yes);
            ans = Math.max(ans,stepmax);
        }
        return ans;
    }
}


//Sample Answer
