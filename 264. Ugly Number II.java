class Solution {
    public int nthUglyNumber(int n) {
        int[] base = new int[]{2, 3, 5};
        int[] index = new int[]{0, 0, 0};
        int[] cur = new int[]{2, 3, 5};
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) min = Math.min(min, cur[j]);
            ans[i] = min;
            for (int j = 0; j < 3; j++){
                if (cur[j] == min) {
                    cur[j] = base[j] * ans[++index[j]];
                }
            }
        }
        return ans[n - 1];
    }
}
