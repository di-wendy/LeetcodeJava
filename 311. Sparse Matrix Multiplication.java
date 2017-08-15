public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        //A(a,b) x B(b,c) = C(a,c)
        //C[a1,c1] = sum(a[1,x] * b[x,1]);
        int a = A.length;
        int b = A[0].length;
        
        int c = B[0].length;
        
        int[][] ans = new int[a][c];
        
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                if (A[i][j] != 0){
                    for (int k = 0; k < c; k++){
                        ans[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        
        return ans;
        
    }
}
