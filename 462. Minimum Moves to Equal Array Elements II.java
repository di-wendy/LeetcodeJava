class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int sum = 0;
        for (int n : nums) sum += (Math.abs(n - median));
        return sum;
    }
}
