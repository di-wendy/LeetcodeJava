public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        int ans = nums.length + 1; //return 0 if not exsit
        int i = 0, j =0, sum = 0;
        while(j < nums.length){
            sum += nums[j];
            if(sum >=s) {
                while(sum >=s){
                    sum -= nums[i];
                    i ++;
                }
                i --;
                sum += nums[i];
                ans = Math.min(ans, j - i + 1);
            }
            j ++;
        }
        if(ans == nums.length + 1) return 0;
        return ans;
    }
}