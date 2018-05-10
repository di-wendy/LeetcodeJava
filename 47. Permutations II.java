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

//Easier to understand
class Solution {
    //Key: For repeated element, if not selected the first one, 
    //will not select the rest
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            helper(ans, new ArrayList<Integer>(), new boolean[nums.length], nums);
            return ans;
    }
    
    public void helper(List<List<Integer>> ans,
                      List<Integer> temp,
                      boolean[] visited,
                      int[] nums){
        if (temp.size() == nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                if (i > 0 && nums[i - 1] == nums[i]){
                    if (!visited[i - 1]){
                        continue;
                    }
                }
                visited[i] = true;
                temp.add(nums[i]);
                helper(ans, temp, visited, nums);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
