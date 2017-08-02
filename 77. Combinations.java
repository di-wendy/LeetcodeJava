public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans,List<Integer> temp, int pos, int n, int k){  
        if(temp.size() == k){
            ans.add(new ArrayList(temp));
            return;
        }
         for(int i = pos; i <= n; i++){
            temp.add(i);
            helper(ans, temp, i + 1, n, k);
            temp.remove(temp.size() - 1);
		}
    }
}