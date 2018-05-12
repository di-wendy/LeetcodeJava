class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        
        //Error Case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        
        int[] dr = new int[]{0, -1, 0, 1};
        int[] dc = new int[]{1, 0, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int r = 0, c = 0, dir = 0; //right, down, left, up, loop
        
        while (ans.size() < m * n){
            if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] ){
                r -= dr[dir % 4];
                c -= dc[dir % 4];
                dir += 1;
            }
            else{
                ans.add(matrix[r][c]);
                visited[r][c] = true;
            }
            r = r + dr[dir % 4];
            c = c + dc[dir % 4];
        }
        
        return ans;
    }
}
