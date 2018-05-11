class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        
        for (int i = 1; i < nums.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (reach[j] && (i - j) <= nums[j]){
                    reach[i] = true;
                    break;
                }
            }
        }
        return reach[nums.length - 1];
    }
}
