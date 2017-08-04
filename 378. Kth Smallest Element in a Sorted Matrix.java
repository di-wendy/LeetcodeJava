class Pair{
    public int x, y, val;
    public Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class Paircompare implements Comparator<Pair>{
    public int compare(Pair A, Pair B){
        return A.val - B.val;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k,new Paircompare());
        
        pq.add(new Pair(0,0,matrix[0][0]));
        
        for(int i = 0; i < k - 1; i++){
            Pair start = pq.poll();
            for(int j = 0; j < 2; j++){
                int x = start.x + dx[j];
                int y = start.y + dy[j];
                if(x < matrix.length && y < matrix[0].length &&
                  !visited[x][y]){
                    pq.add(new Pair(x,y,matrix[x][y]));
                    visited[x][y] = true;
                }
            }
        }
        
        return pq.peek().val;
    }
}
