public class Solution {
    public int minCostII(int[][] costs) {
        
        if(costs.length == 0 || costs[0].length == 0) return 0;
        
        int n = costs.length;
        int k = costs[0].length;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k; j++){
                int temp = Integer.MAX_VALUE;
                for(int h = 0; h < k; h++){
                    if(h != j){
                        temp = Math.min(temp,costs[i - 1][h]);
                    }
                }
                costs[i][j] = costs[i][j] + temp;
            }
        }
                
        int ans = Integer.MAX_VALUE;
        
        for(int j = 0; j < k; j++){
            ans = Math.min(ans,costs[(n - 1)][j]);
        }
        
        return ans;
    }
}
