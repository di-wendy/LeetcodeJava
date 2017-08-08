public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length==0 || nums[0].length==0) return nums;
        
        int m = nums.length;
        int n = nums[0].length;
        if(m*n != r*c) return nums;
        int[][] ans = new int[r][c];
        
        for(int i = 0; i <m; i++){
            for(int j = 0; j <n; j++){
                ans[(i*n+j)/c][(i*n+j)%c] = nums[i][j];
            }
        }
        
        return ans;
    }
}