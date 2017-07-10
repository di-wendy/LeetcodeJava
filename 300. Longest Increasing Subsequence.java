public class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int[] longest = new int[nums.length];
        
        //Initiate
        for(int i = 0; i < nums.length; i++){
            longest[i] = 1;
        }
        
        //Update
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    longest[i] = Math.max(longest[i],longest[j] + 1);
                }
            }
        }
        
        //Return Max Value
        int ans = -1;
        for(int num : longest){
            ans = Math.max(ans, num);
        }
        
        return ans;
    }
}