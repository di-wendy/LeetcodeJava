class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--){
            int k = 0, j = i - 1;
            while (k < j){
                if (nums[i] + nums[j] + nums[k] < target) {
                    count+= (j - k);
                    k++;
                }
                else j--;
            }
        }
        return count;
    }
}
