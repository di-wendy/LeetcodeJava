class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        if(n == 1) return ans;
        dfs(2, n);
        return ans;
    }
    
    public void dfs(int start, int remain){
        if (remain == 1){
            if (path.size()!=1){
                ans.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        for (int i = start; i <= remain; i++){
            if (i > remain / i){
                break;
            }
            if(remain % i == 0){
                path.add(i);
                dfs(i, remain/i);
                path.remove(path.size() - 1);
            }
        }
        
        path.add(remain);
        dfs(remain, 1);
        path.remove(path.size() - 1);
        
    }
}
