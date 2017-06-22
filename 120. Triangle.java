public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int[] store = new int[triangle.size()];
        
        store[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < triangle.size(); i++){
            
            for(int j = i; j > 0; j--){
                if(i == j) {
                    store[j] = store[j-1] + triangle.get(i).get(j);
                }
                else {
                    store[j] = (Math.min(store[j-1],store[j]) + triangle.get(i).get(j));
                }
            }
            store[0] += triangle.get(i).get(0);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int n:store){
            ans = Math.min(n,ans);
        }
        
        return ans;
    }
}
