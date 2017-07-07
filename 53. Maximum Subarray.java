//65.5%

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int[] store = new int[nums.length];
        store[0] = nums[0];
        int ans = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(store[i-1] > 0){
                store[i] = store[i-1] + nums[i];
            }
            else{
                store[i] = nums[i];
            }
            ans = Math.max(ans,store[i]);
        }
        
        return ans;
        
    }
}
