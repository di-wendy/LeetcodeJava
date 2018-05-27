class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int ans = nums.length + 1;
        int total = 0;
        
        while (start < nums.length && end <= nums.length){
            if (total < s && end < nums.length){
                total += nums[end];
                end ++;
            } else {
                if (total >= s) ans = Math.min(ans, end - start);
                total -= nums[start];
                start++;
            }
        }
        
        return (ans > nums.length) ? 0 : ans;
    }
}
