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
