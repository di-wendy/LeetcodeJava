class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int n : piles) max = Math.max(max, n);
        int i = 1;
        int j = max;
        while (i + 1 < j){
            int mid = i + (j - i)/2;
            if (eatUp(piles, H, mid)){
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return eatUp(piles, H, i) ? i : j;
    }
    
    public boolean eatUp(int[] piles, int H, int Q){
        int ans = 0;
        for (int n : piles){
            ans += ((n - 1)/Q + 1);
        }
        return ans <= H;
    }
}
