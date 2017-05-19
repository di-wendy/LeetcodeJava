//71.71
public class Solution {
    public int arrayPairSum(int[] nums) {
        
        //The aim is to find the min(0) and min(n)
        Arrays.sort(nums);
        
        int ans = 0;
        
        for(int i = 0; i < nums.length; i= i+2){
            ans += nums[i];
        }
        return ans;
        
    }
}
