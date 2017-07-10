public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<> ();
        Arrays.sort(candidates); //to move duplicates together
        helper(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int remain, int pos){
        if(remain <= 0){
            if(remain == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        for(int i = pos; i < candidates.length; i++){
            if(i > pos && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            remain -= candidates[i];
            helper(ans, temp, candidates, remain, i+1);
            temp.remove(temp.size() - 1);
            remain += candidates[i];
        }
    }
}