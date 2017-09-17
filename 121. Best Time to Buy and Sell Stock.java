//89%
public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0){
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                if(prices[i] - min > profit){
                    profit = prices[i] - min;
                }
            }
        }
        
        return profit;
    }
}

//48%
public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length <= 1) return 0;
        
        int min = prices[0];
        int max = prices[0];
        int profit = max - min;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > max){
                max = prices[i];
                profit = Math.max(profit,max - min);
            }
            if(prices[i] < min){
                max = prices[i];
                min = prices[i];
            }
        }
        return profit;
    }
}

//Short Code
class Solution {
    public int maxProfit(int[] prices) {
        //Kadane's Algorithm
        int temp = 0, overall = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++){
            temp = prices[i] - prices[i - 1];
            overall = Math.max(0, overall + temp);
            res = Math.max(res, overall);
        }
        return res;
    }
}
