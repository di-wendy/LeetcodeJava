class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0) return ans;
        int count = 1;
        int[] dr = new int[]{0, -1, 0, 1}; //right, down, left, up
        int[] dc = new int[]{1, 0, -1, 0};
        int i = 0;
        int j = 0;
        int dir = 0;
        while (count <= n * n){
            //System.out.print(count);
            if (i >= n || j >= n || i < 0 || j < 0 || ans[i][j] != 0){
                i -= dr[dir%4];
                j -= dc[dir%4]; //back
                dir += 1;
            } else {
                ans[i][j] = count;
                count++;
            }
            i += dr[dir%4];
            j += dc[dir%4]; //back
        }
        return ans;
    }
}
