class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        //Construct a presum matrix
        long[][] presum = new long[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                presum[i][j] = (j == 0) ? matrix[i][j] : presum[i][j - 1] + matrix[i][j];
            }
        }
        
        //Fix col num and find sum
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++){
            for (int j = i; j < matrix[0].length; j++){
                for (int h = 0; h < matrix.length; h++){
                    long sum = 0;
                    for (int m = h; m < matrix.length; m++){
                        sum += (presum[m][j] - ((i == 0) ? 0 : presum[m][i - 1]));
                        if (sum <= k){
                            ans = Math.max(ans, (int)sum);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
