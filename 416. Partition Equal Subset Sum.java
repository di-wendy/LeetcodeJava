class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        if (total % 2 != 0) return false;
        int target = total/2;
        Arrays.sort(nums);
        return searchTarget(0, 0, nums, target);
    }
    
    public boolean searchTarget(int cur, int index, int[] nums, int target){
        if (cur == target) return true;
        if (index >= nums.length) return false;
        if (cur > target) return false;
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (searchTarget(cur + nums[index], i + 1, nums, target)) return true;
        }
        return false;
    }
}
