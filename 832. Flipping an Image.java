class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        flip(A);
        invert(A);
        return A;
    }
    
    public int[][] flip(int[][] A){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length/2; j++){
                int temp = A[i][j];
                A[i][j] = A[i][A[0].length - j - 1];
                A[i][A[0].length - j - 1] = temp;
            }
        }
        return A;
    }
    public int[][] invert(int[][] A){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
               A[i][j] = (A[i][j] == 0) ? 1 : 0;
            }
        }
        return A;
    }
}
