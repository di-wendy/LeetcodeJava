class Solution {
    public int numSquares(int n) {
        
        int[] square = new int[n + 1];
        
        if (n == 0) return 0;
        square[0] = 0;
        square[1] = 1;
        
        for (int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int index = (int)Math.sqrt(i);
            for (int j = index; j >= 1; j--){
                if (square[i - j*j] < min){
                    min = square[i - j*j];
                }
            }
            square[i] = min + 1;
        }
        
        return square[n];
    }
}
