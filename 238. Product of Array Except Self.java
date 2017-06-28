public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] store = new int[nums.length];
        
        int p = 1;
        for(int i = 0; i < nums.length; i++){
            if(i >= 1) {p *= nums[i - 1];}
            store[i] = p;
        }
        
        p = 1;
        
        
        for(int i = nums.length - 2; i >= 0; i--){
            p *= nums[i + 1];
            store[i] *= p;
        }
        
        
        return store;
    }
}
