public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int remain, int pos){
        if(remain <= 0){
            if(remain == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        for(int i = pos; i < nums.length; i++){
            temp.add(nums[i]);
            helper(ans, temp, nums, remain - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}