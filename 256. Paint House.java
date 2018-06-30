//DP Constant Space
class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        //init
        for (int i = 1; i < costs.length; i++){
            int tempBlue = blue;
            int tempGreen = green;
            blue = Math.min(red, green) + costs[i][1];
            green = Math.min(tempBlue, red) + costs[i][2];
            red = Math.min(tempBlue, tempGreen) + costs[i][0];
        }
        return Math.min(red, Math.min(blue, green));
    }
}
//Dynamic Programming 2ms
public class Solution {
    public int minCost(int[][] costs) {
        

        if(costs == null || costs.length==0) return 0;
        int n = costs.length;
        int[][] min = new int[n][3];
        
        min[0][0] = costs[0][0];
        min[0][1] = costs[0][1];
        min[0][2] = costs[0][2];
        
        for(int i=1; i<n; i++){
            min[i][0] = costs[i][0] + Math.min(min[i-1][1],min[i-1][2]);
            min[i][1] = costs[i][1] + Math.min(min[i-1][0],min[i-1][2]);
            min[i][2] = costs[i][2] + Math.min(min[i-1][0],min[i-1][1]);
        }
        
        return Math.min(min[n-1][0],Math.min(min[n-1][1],min[n-1][2]));
    }
}
