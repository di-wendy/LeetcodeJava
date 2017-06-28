public class Solution {
    public int maxProduct(int[] nums) {
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        max[0] = nums[0];
        min[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
            int a = max[i-1]*nums[i];
            int b = min[i-1]*nums[i];
            int c = nums[i];
            
            max[i] = Math.max(a,Math.max(b,c));
            min[i] = Math.min(a,Math.min(b,c));
        }
        
        int ans = Integer.MIN_VALUE;

        for(int n:max){
            ans = Math.max(ans,n);
        }

        return ans;
    }
}
