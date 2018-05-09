//
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
//Two Array
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        
        pos[0] = nums[0];
        neg[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > 0){
                pos[i] = Math.max(nums[i], pos[i - 1] * nums[i]);
                neg[i] = Math.min(nums[i], neg[i - 1] * nums[i]);
            }
            if (nums[i] < 0){
                pos[i] = Math.max(nums[i], neg[i - 1] * nums[i]);
                neg[i] = Math.min(nums[i], pos[i - 1] * nums[i]);
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            ans = Math.max(ans, pos[i]);
            ans = Math.max(ans, neg[i]);
        }
        return ans;
    }
}

//New Version
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        
        pos[0] = nums[0];
        neg[0] = nums[0];
        
        //Record the maximum product subarray end at position i
        for (int i = 1; i < nums.length; i++){
            pos[i] = Math.max(pos[i - 1] * nums[i], Math.max(nums[i], neg[i - 1] * nums[i]));
            neg[i] = Math.min(pos[i - 1] * nums[i], Math.min(nums[i], neg[i - 1] * nums[i]));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            res = Math.max(res, pos[i]);
            res = Math.max(res, neg[i]);
        }
        
        return res;
    }
}
