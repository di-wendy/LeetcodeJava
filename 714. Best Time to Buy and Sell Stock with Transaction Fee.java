class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        //init
        int cash = 0;
        int hold = -prices[0];
        
        //Loop days
        for (int i = 1; i < prices.length; i++){
            cash = Math.max(cash, hold + prices[i] - fee); //hold or sell for current price
            hold = Math.max(hold, cash - prices[i]); //hold or buy
        }
        
        return cash;
    }
}
