public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int ans = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i ++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int total = nums[i] + nums[start] + nums[end];
                if(total > target){
                    end --;
                }
                else if(total < target){
                    start ++;
                }
                else if(total == target){
                    return target;
                }
                
                if(Math.abs(target - total) < Math.abs(target - ans)){
                    ans = total;
                }
            }
        }
        
        return ans;
        
    }
}
