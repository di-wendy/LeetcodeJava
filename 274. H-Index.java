public class Solution {
    public int hIndex(int[] citations) {

        if (citations.length == 0) return 0;
        
        Arrays.sort(citations);
        
        int ans = 0;
        
        for(int i = citations.length - 1; i >=0; i--){
            int temp = Math.min(citations.length - i, citations[i]);
            ans = Math.max(ans,temp);
        }
        
        return ans;
    }
}
