class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] v = new boolean[maze.length][maze[0].length];
        if (find(maze, start, v, destination)) return true;
        return false;
    }
    
    public int[] move(int[][] maze, int[] pos, int dir){
        int[] u = pos.clone();
        
        switch(dir){
            case 0 : //up
                while (u[0] - 1 >= 0 && maze[u[0] - 1][u[1]] != 1) u[0]-=1;
                break; 
            case 1 : //down
                while (u[0] + 1 <= maze.length - 1 && maze[u[0] + 1][u[1]] != 1) u[0]+=1;
                break; 
            case 2 : //left     
                while (u[1] - 1 >= 0 && maze[u[0]][u[1] - 1] != 1) {u[1] = u[1] - 1;}
                break; 
            case 3 : //right
                while (u[1] + 1 <= maze[0].length - 1 && maze[u[0]][u[1] + 1] != 1) u[1]+=1;
                break; 
        }
        return u;
    }
    
    public boolean find(int[][] maze, int[] pos, boolean[][] v, int[] d){
        if (pos[0] == d[0] && pos[1] == d[1]) return true;
        if (v[pos[0]][pos[1]]) return false;
        v[pos[0]][pos[1]] = true;
        for (int i = 0; i < 4; i++){
            int[] u = move(maze, pos, i);
            if (find(maze, u, v, d)) return true;
        }
        return false;
    }
}
