class Solution {
    
    int result = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, 0, S);
        return result;
    }
    
    public void helper(int[] nums, int pos, int sum, int S){
        if(nums.length == pos){
            if(sum == S) result += 1;
            return;
        }
        helper(nums, pos + 1, sum + nums[pos], S);
        helper(nums, pos + 1, sum - nums[pos], S);
    }
}
