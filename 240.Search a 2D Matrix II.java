public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        //Zig Zag Search
        int r = matrix.length - 1;
        int c = 0;
        
        while(r >=0 && c < matrix[0].length){
            if(target == matrix[r][c]){
                return true;
            }
            else if (target > matrix[r][c]){
                c ++;
            }
            else if (target < matrix[r][c]){
                r --;
            }
        }
        
        return false;
    }
}
