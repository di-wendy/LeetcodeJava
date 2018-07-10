class Solution {
    public void nextPermutation(int[] nums) {
        //From end, find the first num that is decreasing
        //1,2,4 here 2 is decreasing
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        //when break, either i == 0 || nums[i] > nums[i - 1]
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        //find the num to replace i - 1
        int replace = nums.length - 1;
        while (replace > i - 1){
            if (nums[replace] > nums[i - 1]) break;
            replace--;
        }
        int temp = nums[replace];
        nums[replace] = nums[i - 1];
        nums[i - 1] = temp;
        Arrays.sort(nums, i, nums.length);
    }
}
