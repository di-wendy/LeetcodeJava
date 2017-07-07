public class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        //Initiate to False
        boolean[] used = new boolean[nums.length]; 
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(ans, new ArrayList<>(), nums, used);
        
        return ans;
        
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i >0 && nums[i] == nums[i-1] && !used[i - 1])){continue;} 
			//Keep the numbers in order
            else{
                temp.add(nums[i]);
                used[i] = true;
                helper(ans, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() -1);
            }
        }
    }
}