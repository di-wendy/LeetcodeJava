class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return getMin(x) + getMin(y);
    }
    
    public int getMin(List<Integer> x){
        Collections.sort(x);
        int res = 0;
        int i = 0;
        int j = x.size() - 1;
        while (i < j){
            res += x.get(j--) - x.get(i++); //small -> big
        }
        return res;
    }
}
