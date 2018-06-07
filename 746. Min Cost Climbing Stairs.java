class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 1) return 0;
        int[] steps = new int[cost.length];
        steps[0] = cost[0];
        steps[1] = cost[1];
        for (int i = 2; i < cost.length; i++){
            steps[i] = Math.min(steps[i - 2], steps[i - 1]) + cost[i];
        }
        return Math.min(steps[cost.length - 2], steps[cost.length - 1]); //Key is how to define top
    }
}
