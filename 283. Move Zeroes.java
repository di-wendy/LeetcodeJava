class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int insert = 0;
        for (int n : nums){
            if (n != 0) nums[insert++] = n;
        }
        while (insert < nums.length){
            nums[insert++] = 0;
        }
    }
}

//Swap
class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0; //point to zero
        int q = 0; //the first non zero from p
        
        while (p < nums.length && q < nums.length){
            if (nums[p] == 0){
                while (q < nums.length && nums[q] == 0){
                    q ++;
                }
                if (q == nums.length){
                    break;
                }
                swap(nums, p, q);
            }
            p++;
            q++;
        }
        
        return;
    }
    
    public void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
