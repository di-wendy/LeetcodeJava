public class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<String>();
        if(nums.length == 1){
            ans.add(nums[0] + "");
            return ans;
        }
        
        int i = 0;
        while(i < nums.length){
            int start = nums[i];
            while(i+1 < nums.length && nums[i+1] - nums[i] == 1){
                i++;
            }
            if(start == nums[i]){
                ans.add(nums[i] + "");
            }
            else{
                ans.add(start + "->" + nums[i]);
            }
            i++;
        }
        
        return ans;
    }
}