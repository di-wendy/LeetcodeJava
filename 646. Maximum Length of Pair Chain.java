public class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs,(a,b) -> a[0] - b[0]);
        
        int ans = 0;
        int[] mcl =  new int[pairs.length];
        
        for(int i = 0; i < mcl.length; i++){
            mcl[i] = 1;
        }
        
        for(int i = 1; i < mcl.length; i++){
            for(int j = 0; j < i; j++){
                if(pairs[i][0] > pairs[j][1] && mcl[i] < mcl[j] + 1){
                    mcl[i] = mcl[j] + 1;
                }
            }
        }
        
        for(int i = 0; i < mcl.length; i++){
            ans = Math.max(ans, mcl[i]);
        }
        
        return ans;
    }
    
}
