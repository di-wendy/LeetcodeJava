public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> ans = new HashSet<List<Integer>> ();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(0,temp,ans,nums);
        List result = new ArrayList(ans);
        
        return result;
    }
    
    public void dfs(int current, List<Integer> temp,Set<List<Integer>> ans, int[] nums){
        if(temp.size()>=2) ans.add(new ArrayList(temp));
        
        for(int i=current; i<nums.length; i++){
            if(temp.size()==0||nums[i]>=temp.get(temp.size()-1)){
                temp.add(nums[i]);
                dfs(i+1,temp,ans,nums); //tree node from i not current
                temp.remove(temp.size()-1);
            }
        }
    }
}
