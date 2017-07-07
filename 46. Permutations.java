public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(ans, new ArrayList<Integer>(), nums);
        
        return ans;
        
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                helper(ans, temp, nums);
                temp.remove(temp.size() -1);
            }
        }
    }
}