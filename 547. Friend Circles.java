class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int m = M.length, n = M[0].length;
        int[] father = new int[m];
        for (int i = 0; i < m; i++) father[i] = i;
        for (int i = 0; i < m; i++){
            for (int j = i + 1; j < n; j ++){
                if (M[i][j] == 1){
                    int father1 = findfather(i, father);
                    int father2 = findfather(j, father);
                    father[father2] = father1;
                }
            }
        }
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < m; i++){
            num.add(findfather(i, father));
        }
        return num.size();
    }
    
    public int findfather(int i, int[] father){
        if (father[i] == i){
            return i;
        }
        return findfather(father[i], father);
    }
}
