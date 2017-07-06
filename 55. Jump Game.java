public class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length < 1) return true;
        
        boolean[] store = new boolean[nums.length];
        store[0] = true;
        
        for(int i = 1; i < nums.length; i++){
            store[i] = false;
            for(int j = i - 1; j >= 0; j --){
                if(store[j] == true && (i - j) <= nums[j]){
                    store[i] = true;
                    break;
                }
            }
        }
        
        return store[nums.length - 1];
    }
}