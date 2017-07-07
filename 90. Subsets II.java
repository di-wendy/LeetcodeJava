public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        helper(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> sub, int[] nums, int pos){
        ans.add(new ArrayList<>(sub));
        //i is the pos to add num in list to sub
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i-1] == nums[i]){
                continue;
            }
            sub.add(nums[i]);
            helper(ans, sub, nums, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}