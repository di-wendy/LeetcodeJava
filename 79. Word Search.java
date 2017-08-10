public class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(board.length <= 0 || board[0].length <= 0) return false;
        if(word.length() <= 0) return true;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(check(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean check(char[][] board, String word, int index, int i, int j){
        
        if(index == word.length()) return true;
        if(i < 0 || j <0 || i == board.length || j == board[0].length) return false;
        
        if(word.charAt(index) == board[i][j]){
            board[i][j] = '*';
            boolean res = check(board, word, index + 1, i - 1, j) ||
                check(board, word, index + 1, i + 1, j) ||
                check(board, word, index + 1, i, j - 1)||
                check(board, word, index + 1, i, j + 1);
            
            board[i][j] = word.charAt(index);
            
            return res;
        }
        else{
            return false;
        }
    }
}
