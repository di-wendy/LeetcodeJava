class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = n;
        int[] father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
        
        for (int[] edge : edges){
            if (findfather(father, edge[0]) != findfather(father, edge[1])){
                father[findfather(father, edge[0])] = findfather(father, edge[1]); 
                // Union Father
                ans--;
            }
        }
        return ans;
    }
    
    public int findfather(int[] father, int n){
        while (father[n] != n){
            n = father[n];
        }
        return n;
    }
}
