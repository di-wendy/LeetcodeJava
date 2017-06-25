public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0, end = row * col - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            int r = mid / col;
            int c = mid % col;

            int midval = matrix[r][c];
            if(midval == target){
                return true;
            }
            if(midval < target){
                start = mid;
            }
            if(midval > target){
                end = mid;
            }
        }
        
        if(matrix[start/col][start%col] == target || matrix[end/col][end%col] == target){
            return true;
        }
        
        return false;
    }
}
