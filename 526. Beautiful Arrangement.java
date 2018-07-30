class Solution {
    public int countArrangement(int N) {
        int[] count = new int[]{0};
        boolean[] used = new boolean[N + 1];
        helper(N, used, 1, count);
        return count[0];
    }
    
    public void helper(int N, boolean[] used, int cur, int[] count){
        if (cur == N + 1) {
            count[0] += 1;
            return;
        }
        for (int i = 1; i <= N; i++){
            if(!used[i]){
                if ((cur >= i && cur % i == 0) || (cur < i && i % cur == 0)){
                    used[i] = true;
                    helper(N, used, cur + 1, count);
                    used[i] = false;
                }
            }
        }
    }
}
