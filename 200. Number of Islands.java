public class Solution {
    
    public int numIslands(char[][] grid) {
        
        if (grid==null||grid.length==0 || grid[0].length==0) return 0;
        int M = grid.length;
        int N = grid[0].length;
        int count = 0;
        
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if (grid[i][j]=='1'){
                    count += 1;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    
    public void dfs(int x, int y, char[][] grid){
        grid[x][y] = '0';
        if(x-1>=0 && grid[x-1][y]=='1'){
            dfs(x-1,y,grid);
        }
        if(y-1>=0 && grid[x][y-1]=='1'){
            dfs(x,y-1,grid);
        }
        if(x+1<grid.length && grid[x+1][y]=='1'){
            dfs(x+1,y,grid);
        }
        if(y+1<grid[0].length && grid[x][y+1]=='1'){
            dfs(x,y+1,grid);
        }
        
        return;
    }
}

//Second Solution
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        Stack<Integer> x = new Stack<>();
        Stack<Integer> y = new Stack<>();
        int count = 0;
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    count ++;
                    x.push(i);
                    y.push(j);
                    grid[i][j] = '0';
                }
                while (!x.isEmpty()){
                    int px = x.pop();
                    int py = y.pop();
                    for (int k = 0; k < 4; k++){
                        if (px + dx[k] >= 0 && px + dx[k] < grid.length
                        && py + dy[k] >= 0 && py + dy[k] < grid[0].length){
                            if (grid[px + dx[k]][py + dy[k]] == '1'){
                                x.push(px + dx[k]);
                                y.push(py + dy[k]);
                                grid[px + dx[k]][py + dy[k]] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
