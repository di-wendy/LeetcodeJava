/11%
public class Solution {
    public int maxProfit(int[] prices) {
        
        int ans = 0;
        if(prices.length == 0 || prices.length == 1){
            return ans;
        }
        
        int start = -1;
        
        for(int i = 0; i < prices.length-1; i++){

            if((i==0 && prices[i+1] > prices[i]) || (i!=0 && prices[i-1] >= prices[i] && prices[i+1] > prices[i])){
                start = prices[i];
            }
            if(start != -1 && prices[i] > start && prices[i+1] <= prices[i]){
                ans += (prices[i] - start);
                start = -1;
            }
        }
        
        if(start != -1){
            ans += (prices[prices.length-1] - start);
        }
        
        return ans;
        
    }
}

//Simple Solution

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                ans += (prices[i+1] - prices[i]);
            }
        }
        return ans;
    }
}
