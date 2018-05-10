class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length; //row
        int n = board[0].length; //column
        
        //Check row
        for (int i = 0; i < m; i++){
            if (!isValid(board[i])){
                return false;
            }
        }
        //Check col
        for (int j = 0; j < n; j++){
            char[] temp = new char[m];
            for (int i = 0; i < m; i++){
                temp[i] = board[i][j];
            }
            if (!isValid(temp)){
                return false;
            }
        }
        
        //Check square
        for (int i = 0; i < m; i+=3){
            for (int j = 0; j < n; j+=3){
                char[] temp = new char[m];
                for (int k = 0; k < 3; k++){
                    for (int h = 0; h < 3; h++){
                        temp[k*3 + h] = board[i + k][j + h];
                    }
                }
                if (!isValid(temp)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[] board){
        Set<Character> hs = new HashSet<>();
        for (char c : board){
            if ((c - '0' > 9 || c - '0' < 1) && c != '.'){
                System.out.print(c);
                return false;
            }
            if (hs.contains(c)){
                return false;
            }
            if (c != '.'){
                hs.add(c);
            }
        }
        return true;
    }
}
