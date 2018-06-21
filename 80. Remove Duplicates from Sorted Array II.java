class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 1;
        int j = 1;
        int cur = nums[0];
        int count = 1;
        while (j < nums.length){
            if (cur == nums[j]) count++;
            else {
                cur = nums[j];
                count = 1;
            }
            nums[i] = nums[j];
            if (count <= 2) i++;
            j++;
        }
        return i;
    }
}
