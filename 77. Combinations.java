class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //n*(n - 1)/k!... k items C(4, 2)
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, n, k, 1, new ArrayList<Integer>());
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, int n, int k, int cur, List<Integer> temp){
        if (temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for (int i = cur; i <= n; i++){
            temp.add(i);
            helper(ans, n, k, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
