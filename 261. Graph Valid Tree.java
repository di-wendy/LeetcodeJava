class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Tree is connected and nonCyclic, use union find
        int[] father = new int[n];
        Arrays.fill(father, -1);
        
        if (edges.length != n - 1) return false;
        
        //Processs Edges
        for (int[] edge : edges){
            int xfather = find(father, edge[0]);
            int yfather = find(father, edge[1]);
            
            if (xfather == yfather) return false;
            father[xfather] = yfather; //KEY
        }
        return true;
    }
    
    public int find(int[] father, int child){
        if (father[child] == -1) return child;
        return find(father, father[child]);
    }
}
