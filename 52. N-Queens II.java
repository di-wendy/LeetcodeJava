class Solution {
    public int totalNQueens(int n) {
        int[] ans = new int[1];
        int[] queen = new int[n];
        search(n, queen, 0, ans);
        return ans[0];
    }
    
    public void search(int n, int[] queen, int row, int[] ans){
        if (row == n) {
            ans[0]++;
            return;
        }
        for (int i = 0; i < n; i++){
            queen[row] = i; //try every row
            if(isValid(queen, row)){
                search(n, queen, row + 1, ans);
            }
        }
    }
    
    public boolean isValid(int[] queen, int row){
        for (int i = 0; i < row; i++){
            if (queen[i] == queen[row] || 
               Math.abs(queen[row] - queen[i]) == row - i){
                return false;
            }
        }
        return true;
    }
}
