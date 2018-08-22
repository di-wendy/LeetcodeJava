class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return matrix;
        boolean[][] v = new boolean[matrix.length][matrix[0].length];
        //put 0s in the list, for each cell, search for (4) dirs
        Queue<int[]> q = new LinkedList<>();
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    q.offer(new int[]{i, j});
                    v[i][j] = true;
                }
            }
        }
        int dis = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++){
                    int newX = cur[0] + dx[k];
                    int newY = cur[1] + dy[k];
                    if (newX >= 0 && newX < matrix.length && newY >= 0 
                        && newY < matrix[0].length && !v[newX][newY]){
                        q.offer(new int[]{newX, newY});
                        matrix[newX][newY] = dis;
                        v[newX][newY] = true;
                    }
                }
            }
            dis++;
        }
        return matrix;
    }
}
