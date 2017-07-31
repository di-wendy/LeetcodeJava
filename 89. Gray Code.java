public class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        
        for(int i = 0; i < n; i++){
            int k = ans.size();
            for(int j = k - 1; j >=0; j--){
                ans.add(ans.get(j)|1<<i);
            }
        }
        
        return ans;
    }
}