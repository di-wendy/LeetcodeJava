class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0;
        int end = 0;
        int ans = 0;
        while (end < nums.length){
            if (end > 0 && nums[end - 1] >= nums[end]) start = end;
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
