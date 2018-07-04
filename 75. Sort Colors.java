class Solution {
    public void sortColors(int[] nums) {
        int i = 0; //after last 0
        int j = 0; //after last 1
        int k = nums.length - 1; //before first 2
        while (j <= k){
            if (nums[j] == 2){
                swap(nums, j, k--); //Key 不能跳过
            } else if (nums[j] == 1){
                j++;
            } else if (nums[j] == 0){
                swap(nums, j++, i++);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
